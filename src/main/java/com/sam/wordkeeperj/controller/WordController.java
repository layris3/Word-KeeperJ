package com.sam.wordkeeperj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.wordkeeperj.entity.Meaning;
import com.sam.wordkeeperj.entity.Sentence;
import com.sam.wordkeeperj.entity.Word;
import com.sam.wordkeeperj.service.MeaningService;
import com.sam.wordkeeperj.service.SentenceService;
import com.sam.wordkeeperj.service.WordService;
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
    public Word findWordByWordName(@PathVariable("wordName") String wordName) {
        return this.wordService.find(wordName);
    }

    @GetMapping("/api/categories")
    public List<Map<String, String>> getAllCategories() {
        return this.wordService.getAllCategories();
    }

    @GetMapping("/api/categories/{category}")
    public String getCategoryChapterInfo(@PathVariable String category) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> categoryChapterInfo = this.wordService.getCategoryChapterInfo(category);
        return mapper.writeValueAsString(categoryChapterInfo);
    }

    @GetMapping("/api/words/{category}/{chapter}")
    public List<Word> getChapterWords(@PathVariable String category, @PathVariable String chapter) {
        return this.wordService.getChapterWords(category, chapter);
    }

    @PutMapping("/api/words/{wordName}")
    public void updateWord(@PathVariable("wordName") String wordName, @RequestBody Word word) {
        this.wordService.updateWord(word);

        List<Meaning> meanings = word.getMeanings();
        if (meanings != null) {
            meanings.forEach(
                    (meaning) -> {
                        if (meaning.getId() == 0)
                            this.meaningService.addMeaning(meaning);
                        else
                            this.meaningService.updateMeaning(meaning);
                    });
        }

        List<Sentence> sentences = word.getSentences();
        if (sentences != null) {
            sentences.forEach(
                    (sentence -> {
                        if (sentence.getId() == 0)
                            this.sentenceService.addSentence(sentence);
                        else
                            this.sentenceService.updateSentence(sentence);
                    }));
        }
    }
}
