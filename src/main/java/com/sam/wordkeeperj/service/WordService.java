package com.sam.wordkeeperj.service;

import com.sam.wordkeeperj.entity.Word;
import com.sam.wordkeeperj.mapper.WordMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WordService {
    private final WordMapper wordMapper;

    public WordService(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    public List<Map<String, String>> getAllCategories() {
        return this.wordMapper.getAllCategories();
    }

    public List<Map<String, String>> getCategoryChapterInfo(String category) {
        return this.wordMapper.getCategoryChapterInfo(category);
    }

    public List<Word> getChapterWords(String category, String chapter) {
        return this.wordMapper.getChapterWords(category, chapter);
    }
}
