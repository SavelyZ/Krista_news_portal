package ru.architecture22.IO;

import java.util.List;

public class AllNewsIO {
    private List<NewsIO> listNews;

    public AllNewsIO() {
    }

    public AllNewsIO(List<NewsIO> listNews) {
        this.listNews = listNews;
    }

    public List<NewsIO> getListNews() {
        return listNews;
    }
}
