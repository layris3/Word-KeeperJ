package com.sam.wordkeeperj.mapper;

import com.sam.wordkeeperj.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface WordMapper {

    List<Word> findAll();

    Word findByWordName(@Param("wordName") String wordName);
}
