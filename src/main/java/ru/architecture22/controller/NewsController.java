package ru.architecture22.controller;

import ru.architecture22.controller.BO.*;
import ru.architecture22.DO.NewsDO;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class NewsController implements NewsInter {
    CategoryController categoryController;

    public ArrayList<NewsBO> getListNews() {
        return null;
    }

    public NewsBO convertNewsDOIntoNewsBO(NewsDO newsDO) {
        NewsBO newsBO = new NewsBO();
        newsBO.setId(UUID.randomUUID());
        newsBO.setTitle(newsDO.getTitle());
        newsBO.setText(newsDO.getText());
        newsBO.setImage(newsDO.getImage());
        newsBO.setDate(newsDO.getDate());
        newsBO.setStatus(newsDO.getStatus());
        CategoryBO categBO = new CategoryBO();
        newsBO.setNameCategory(categoryController.findCategoryNameById(newsDO.getIdCategory()));
        return newsBO;
    }

    public UUID addNews(UUID id, String title, StringBuilder text, String nameCateg, Image image) {
        NewsBO newsBO = new NewsBO(id, title, text, nameCateg, image);
        newsBO.getListNewsBO().add(newsBO);
        return newsBO.getId();
    }

    public NewsBO findNewsById(UUID id) {
        for (NewsBO newsBO : NewsBO.getListNewsBO()) {
            if (newsBO.getId().equals(id)) {
                return newsBO;
            }
        }
        return null;
    }

    public void editNewsTitleAndText(UUID id, String newTitle, StringBuilder newText, Image newImage, String newAuthor) {
        NewsBO newsBO = this.findNewsById(id);
        if (newsBO != null) {
            newsBO.setTitle(newTitle);
            newsBO.setText(newText);
            newsBO.setImage(newImage);
            newsBO.setAuthor(newAuthor);
        } else {
            System.out.println("Данная новость отсутствует!");
        }
    }

    public void delNews(UUID id) {
        NewsBO newsBO = this.findNewsById(id);
        if (newsBO != null) {
            NewsBO.getListNewsBO().remove(newsBO);
        } else {
            System.out.println("Данная новость отсутствует!");
        }
    }
}
