package ru.architecture22.IO;

import java.util.ArrayList;
import java.util.UUID;

public class NewsSportTitleIO {
    private UUID id;
    private String title;
    private ArrayList<NewsSportTitleIO> listNewsSportTitle;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<NewsSportTitleIO> getListNewsSportTitle() {
        return listNewsSportTitle;
    }

    public void setListNewsSportTitle(ArrayList<NewsSportTitleIO> listNewsSportTitle) {
        this.listNewsSportTitle = listNewsSportTitle;
    }
}
