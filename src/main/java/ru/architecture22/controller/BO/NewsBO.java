package ru.architecture22.controller.BO;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class NewsBO {
    private UUID id;
    private static ArrayList<NewsBO> listNewsBO;
    private String nameCategory;
    private String title;
    private StringBuilder text;
    private Image image;
    private Date date;
    private String status;
    private String author;

    public NewsBO(){}

    public NewsBO(UUID id, String title, StringBuilder text, String nameCategory, Image image){
        this.id = id;
        this.title = title;
        this.text = text;
        this.nameCategory = nameCategory;
        this.image = image;
    }

    public NewsBO(UUID id, String nameCategory, String title, StringBuilder text, Image image, Date date, String status, String author) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.title = title;
        this.text = text;
        this.image = image;
        this.date = date;
        this.status = status;
        this.author = author;
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

    public void setText(StringBuilder text) {
        this.text = text;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setListNewsBO(ArrayList<NewsBO> listNewsBO) {
        this.listNewsBO = listNewsBO;
    }

    public static ArrayList<NewsBO> getListNewsBO() {
        return listNewsBO;
    }

    public UUID getId() {
        return id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getTitle() {
        return title;
    }

    public StringBuilder getText() {
        return text;
    }

    public Image getImage() {
        return image;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getAuthor() {
        return author;
    }
}
