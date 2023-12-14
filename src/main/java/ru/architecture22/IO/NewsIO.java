package ru.architecture22.IO;

import java.util.UUID;

public class NewsIO {
    private UUID id;
    private String nameCategory;
    private String title;
    private String author;
    private StringBuilder text;

    public NewsIO(){}
    public NewsIO(UUID id, String nameCategory, String title) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.title = title;
    }
    public NewsIO(UUID id, String nameCategory, String title, String author) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.title = title;
        this.author = author;
    }
    public NewsIO(UUID id, String nameCategory, String title, String author, StringBuilder text) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }

}
