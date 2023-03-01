package com.sam.wordkeeperj.service;

import com.sam.wordkeeperj.entity.Meaning;
import com.sam.wordkeeperj.mapper.MeaningMapper;
import org.springframework.stereotype.Service;

@Service
public class MeaningService {
    private final MeaningMapper meaningMapper;

    public MeaningService(MeaningMapper meaningMapper) {
        this.meaningMapper = meaningMapper;
    }

    public int updateMeaning(Meaning meaning) {
        return this.meaningMapper.updateMeaning(meaning);
    }

    public int addMeaning(Meaning meaning) {
        return this.meaningMapper.addMeaning(meaning);
    }
}
