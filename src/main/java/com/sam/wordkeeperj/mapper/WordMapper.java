package com.sam.wordkeeperj.mapper;

import com.sam.wordkeeperj.entity.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface WordMapper {

    Word findByWordName(@Param("wordName") String wordName);

    List<Map<String, String>> getAllCategories();

    List<Map<String, String>> getCategoryChapterInfo(@Param("category") String category);

    List<Word> getChapterWords(@Param("category") String category, @Param("chapter") String chapter);

    int updateWord(Word word);
}
