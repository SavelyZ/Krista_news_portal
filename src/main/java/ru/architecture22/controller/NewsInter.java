package ru.architecture22.controller;

import ru.architecture22.controller.BO.NewsBO;

import java.awt.*;
import java.util.List;
import java.util.UUID;

public interface NewsInter {
    List<NewsBO> getListNewsConverted();
    UUID addNews(UUID id, String title, StringBuilder text, String nameCateg, Image image);
    NewsBO findNewsById(UUID id);
    void editNewsTitleAndText(UUID id, String newTitle, StringBuilder newText, Image newImage, String newAuthor);
    void delNews(UUID id);
}
