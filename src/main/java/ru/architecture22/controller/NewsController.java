package ru.architecture22.controller;

import ru.architecture22.controller.BO.*;
import ru.architecture22.DO.NewsDO;
import ru.architecture22.model.Factory;
import ru.architecture22.model.FactoryProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.awt.*;
import java.util.stream.Collectors;

public class NewsController implements NewsInter {
    CategoryController categoryController;

    FactoryProvider factoryProvider;

    public NewsController() {
        factoryProvider = Factory.getProvider(Factory.POSTGRE_SQL_CLIENT);
    }

    public ArrayList<NewsDO> getListNews() {
        return factoryProvider.getNewsList();
    }

    public List<NewsBO> getListNewsConverted() {
        return factoryProvider.getNewsList().stream()
                .map(this::convertNewsDOIntoNewsBO)
                .collect(Collectors.toList());
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

    public List<String> getNewsTitleList() {
        return getListNewsConverted().stream()
                .map(NewsBO::getTitle)
                .collect(Collectors.toList());
    }

    public List<NewsBO> getNewsByCategory(String nameCategory) {
        return getListNewsConverted().stream()
                .filter(news -> Objects.equals(news.getNameCategory(), nameCategory))
                .collect(Collectors.toList());
    }

    public List<NewsBO> getNewsByAuthor(String author) {
        return getListNewsConverted().stream()
                .filter(news -> Objects.equals(news.getAuthor(), author))
                .collect(Collectors.toList());
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
