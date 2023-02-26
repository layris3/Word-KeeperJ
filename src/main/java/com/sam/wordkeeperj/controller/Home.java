package com.sam.wordkeeperj.controller;

import com.sam.wordkeeperj.entity.Word;
import com.sam.wordkeeperj.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Home {
    private final WordMapper wordMapper;

    public Home(WordMapper wordMapper) {

        this.wordMapper = wordMapper;
    }

    @GetMapping("/")
    public List<Word> home() {
        return this.wordMapper.findAll();
    }

    @GetMapping("/{wordName}")
    public Word findUser(@PathVariable String wordName) {
        return this.wordMapper.findByWordName(wordName);
    }
}
