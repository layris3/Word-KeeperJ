package com.sam.wordkeeperj.mapper;

import com.sam.wordkeeperj.entity.Sentence;
import com.sam.wordkeeperj.entity.Word;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SentenceMapper {

    List<Sentence> findAllByWordName(@Param("wordName") String wordName);
}
