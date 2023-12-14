package ru.architecture22.DO;

import java.awt.*;
import java.util.Date;
import java.util.UUID;

public class NewsDO {
    private UUID id;
    private UUID idCategory;
    private String title;
    private StringBuilder text;
    private Image image;
    private Date date;
    private String status;
    private UUID idAuthor;

    public NewsDO(UUID id, UUID idCategory, String title, StringBuilder text,
                  Image image, Date date, String status, UUID idAuthor) {
        this.id = id;
        this.idCategory = idCategory;
        this.title = title;
        this.text = text;
        this.image = image;
        this.date = date;
        this.status = status;
        this.idAuthor = idAuthor;
    }

    public UUID getId() {
        return id;
    }

    public UUID getIdCategory() {
        return idCategory;
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

    public UUID getIdAuthor() {
        return idAuthor;
    }
}
