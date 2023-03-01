package com.sam.wordkeeperj.service;

import com.sam.wordkeeperj.entity.Sentence;
import com.sam.wordkeeperj.mapper.SentenceMapper;
import org.springframework.stereotype.Service;

@Service
public class SentenceService {
    private final SentenceMapper sentenceMapper;

    public SentenceService(SentenceMapper sentenceMapper) {
        this.sentenceMapper = sentenceMapper;
    }

    public int updateSentence(Sentence sentence) {
        return this.sentenceMapper.updateSentence(sentence);
    }

    public int addSentence(Sentence sentence) {
        return this.sentenceMapper.addSentence(sentence);
    }
}
