package com.sam.wordkeeperj.entity;

public class Sentence {
    private Integer id;
    private String wordName;
    private String content;
    private String chinese;

    public Sentence() {
    }

    public Sentence(Integer id, String wordName, String content, String chinese) {
        this.id = id;
        this.wordName = wordName;
        this.content = content;
        this.chinese = chinese;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "id=" + id +
                ", wordName='" + wordName + '\'' +
                ", content='" + content + '\'' +
                ", chinese='" + chinese + '\'' +
                '}';
    }
}
