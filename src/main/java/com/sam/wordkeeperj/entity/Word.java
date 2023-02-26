package com.sam.wordkeeperj.entity;

import java.util.List;

public class Word {
    private String wordName;
    private String chapter;
    private String pronunciation;
    private char isImportant;
    private String category;
    private List<Sentence> sentences;
    private List<Meaning> meanings;

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordName='" + wordName + '\'' +
                ", chapter='" + chapter + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", isImportant=" + isImportant +
                ", category='" + category + '\'' +
                ", sentences=" + sentences +
                ", meanings=" + meanings +
                '}';
    }

    public Word() {
    }

    public Word(String wordName, String chapter, String pronunciation, char isImportant, String category) {
        this.wordName = wordName;
        this.chapter = chapter;
        this.pronunciation = pronunciation;
        this.isImportant = isImportant;
        this.category = category;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public char getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(char isImportant) {
        this.isImportant = isImportant;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
