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

    public Word find(String wordName) {
        return this.wordMapper.findByWordName(wordName);
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

    public int updateWord(Word word) {
        return this.wordMapper.updateWord(word);
    }

    public int addWord(Word word) {
        return this.wordMapper.addWord(word);
    }
}
