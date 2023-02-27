package com.sam.wordkeeperj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sam.wordkeeperj.entity.Word;
import com.sam.wordkeeperj.service.WordService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200/")
public class WordController {
    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
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
}
