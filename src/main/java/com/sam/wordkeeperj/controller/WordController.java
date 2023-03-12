package com.sam.wordkeeperj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.wordkeeperj.entity.Meaning;
import com.sam.wordkeeperj.entity.Sentence;
import com.sam.wordkeeperj.entity.Word;
import com.sam.wordkeeperj.service.MeaningService;
import com.sam.wordkeeperj.service.SentenceService;
import com.sam.wordkeeperj.service.WordService;
import org.apache.ibatis.javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@RestController
@CrossOrigin("http://localhost:4200/")
public class WordController {
    private final WordService wordService;
    private final SentenceService sentenceService;
    private final MeaningService meaningService;

    public WordController(WordService wordService, SentenceService sentenceService, MeaningService meaningService) {
        this.wordService = wordService;
        this.sentenceService = sentenceService;
        this.meaningService = meaningService;
    }

    @GetMapping("/api/words/{wordName}")
    public ResponseEntity<Word> findWordByWordName(@PathVariable("wordName") String wordName) {
        Word word = this.wordService.find(wordName);
        return new ResponseEntity<Word>(word, HttpStatus.OK);
    }

    @GetMapping("/api/categories")
    public ResponseEntity<List<Map<String, String>>> getAllCategories() {
        List<Map<String, String>> ret = this.wordService.getAllCategories();
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }

    @GetMapping("/api/categories/{category}")
    public ResponseEntity<String> getCategoryChapterInfo(@PathVariable String category) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, String>> categoryChapterInfo = this.wordService.getCategoryChapterInfo(category);
            String ret = mapper.writeValueAsString(categoryChapterInfo);
            return new ResponseEntity<>(ret, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/words/{category}/{chapter}")
    public ResponseEntity<List<Word>> getChapterWords(@PathVariable String category, @PathVariable String chapter) {
        List<Word> words = this.wordService.getChapterWords(category, chapter);
        return new ResponseEntity<>(words, HttpStatus.OK);
    }

    @PutMapping("/api/words/{wordName}")
    @Transactional
    public ResponseEntity<HttpStatus> updateWord(@PathVariable("wordName") String wordName, @RequestBody Word word) {
        if (!wordName.equals(word.getWordName())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Word tmp = this.wordService.find(wordName);
        if (tmp == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        this.wordService.updateWord(word);

        List<Meaning> meanings = word.getMeanings();
        if (meanings != null) {
            meanings.forEach(
                    meaning -> {
                        if (meaning.getId() == 0)
                            this.meaningService.addMeaning(meaning);
                        else
                            this.meaningService.updateMeaning(meaning);
                    });
        }

        List<Sentence> sentences = word.getSentences();
        if (sentences != null) {
            sentences.forEach(
                    sentence -> {
                        if (sentence.getId() == 0)
                            this.sentenceService.addSentence(sentence);
                        else
                            this.sentenceService.updateSentence(sentence);
                    });
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/words")
    @Transactional
    public ResponseEntity<HttpStatus> addWord(@RequestBody Word word) {
        Word tmp = this.wordService.find(word.getWordName());
        if (tmp != null) throw new RuntimeException("the word:" + word.getWordName() + "has been existed");

        this.wordService.addWord(word);

        List<Meaning> meanings = word.getMeanings();
        if (meanings != null) {
            meanings.forEach(meaning -> {
                this.meaningService.addMeaning(meaning);
            });
        }

        List<Sentence> sentences = word.getSentences();
        if (sentences != null) {
            sentences.forEach(sentence -> {
                this.sentenceService.addSentence(sentence);
            });
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
