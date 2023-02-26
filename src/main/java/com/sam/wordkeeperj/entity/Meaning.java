package com.sam.wordkeeperj.entity;

public class Meaning {
    private Integer id;
    private String wordName;
    private String type;
    private String content;

    public Meaning() {
    }

    public Meaning(Integer id, String wordName, String type, String content) {
        this.id = id;
        this.wordName = wordName;
        this.type = type;
        this.content = content;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Meaning{" +
                "id=" + id +
                ", wordName='" + wordName + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
