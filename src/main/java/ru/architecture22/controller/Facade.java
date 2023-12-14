package ru.architecture22.controller;

import ru.architecture22.IO.*;
import ru.architecture22.controller.BO.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;

public class Facade {
    NewsController newsController;
    CategoryController categoryController;

    public Facade(NewsController newsController, CategoryController categoryController) {
        this.newsController = newsController;
        this.categoryController = categoryController;
    }

    public void getListNews() {
        this.newsController.getListNews();
    }

    public NewsBO findNewsById(UUID id) {
        return this.newsController.findNewsById(id);
    }

    public UUID addNews(String title, StringBuilder text, CategoryBO categoryBO, Image image) {
        return this.newsController.addNews(UUID.randomUUID(), "Заголовок", new StringBuilder("Текст"), "Имя категории", image);
    }

    public void editNewsTitleAndText(UUID id, String newTitle, StringBuilder newText, Image newImage, String newAuthor) {
        this.newsController.editNewsTitleAndText(id, newTitle, newText, newImage, newAuthor);
    }

    public void delNews(UUID id) {
        this.newsController.delNews(id);
    }

    public void getListCategory() {
        this.categoryController.getListCategory();
    }

    public void addCategory(UUID id, String name) {
        this.categoryController.addCategory(UUID.randomUUID(), "Название категории");
    }

    public CategoryBO findCategoryByNews(NewsBO newsBO){
        return this.categoryController.findCategoryByNews(newsBO);
    }

    public CategoryBO findCategoryByName(String name){
        return this.categoryController.findCategoryByName(name);
    }

    public CategoryBO findCategoryById(UUID id){
        return this.categoryController.findCategoryById(id);
    }

    public String findCategoryNameById(UUID idCateg){
        return this.categoryController.findCategoryNameById(idCateg);
    }

    public void editCategory(String oldName, String newName) {
        this.categoryController.editCategory(oldName, newName);
    }

    public void delCategory(String name) {
        this.categoryController.delCategory(name);
    }

    public NewsAndCategoryIO getNewsAndCategoryIO(UUID idNews) {
        NewsBO newsBO = newsController.findNewsById(idNews);
        CategoryBO categoryBO = categoryController.findCategoryByNews(newsBO);

        NewsAndCategoryIO newsAndCategory = new NewsAndCategoryIO();
        newsAndCategory.setNewsBO(newsBO);
        newsAndCategory.setCategoryBO(categoryBO);
        return newsAndCategory;
    }

    //список новостей в порядке добавления
    public NewsSortAddIO getNewsSortAddIO(ArrayList<NewsBO> listNewsBO) {
        NewsSortAddIO newsSortAdd = new NewsSortAddIO();
        for (int i = 0; i < listNewsBO.size(); i++) {
            newsSortAdd.getListNewsBO().add(listNewsBO.get(i));
        }
        Collections.sort(newsSortAdd.getListNewsBO(), new Comparator<NewsBO>() {
            public int compare(NewsBO newsBO1, NewsBO newsBO2) {
                return newsBO1.getDate().compareTo(newsBO2.getDate());
            }
        });
        return newsSortAdd;
    }

    //список категорий в алфавитном порядке
    public CategoryAlphSortIO getCategoryAlphSortIO(ArrayList<CategoryBO> listCategBO) {
        CategoryAlphSortIO categoryAlphSort = new CategoryAlphSortIO();
        for (int i = 0; i < listCategBO.size(); i++) {
            categoryAlphSort.getListCategoryBO().add(listCategBO.get(i));
        }
        Collections.sort(categoryAlphSort.getListCategoryBO(), new Comparator<CategoryBO>() {
            @Override
            public int compare(CategoryBO categBO1, CategoryBO categBO2) {
                return categBO1.getName().toUpperCase().compareTo(categBO2.getName().toUpperCase());
            }
        });
        return categoryAlphSort;
    }

    //информация о конкретной новости
    public NewsIO getNewsInformIO(UUID idNews) {
        NewsBO newsBO = newsController.findNewsById(idNews);
        NewsIO newsGetInform = new NewsIO();
        newsGetInform.setId(newsBO.getId());
        newsGetInform.setTitle(newsBO.getTitle());
        newsGetInform.setNameCategory(newsBO.getNameCategory());
        return newsGetInform;
    }

    //информация о конкретной категории
    public CategoryIO getCategoryInformIO(UUID idCategory) {
        CategoryBO categBO = categoryController.findCategoryById(idCategory);
        CategoryIO categoryInform = new CategoryIO();
        categoryInform.setId(categBO.getId());
        categoryInform.setName(categBO.getName());
        return categoryInform;
    }

    //заголовки спортивных новостей
    public NewsSportTitleIO getNewsSportTitleIO(ArrayList<NewsBO> listNewsBO) {
        NewsSportTitleIO newsSportTitle = new NewsSportTitleIO();
        for (int i = 0; i < listNewsBO.size(); i++) {
            if (listNewsBO.get(i).getNameCategory().toUpperCase().equals("СПОРТ")){
                NewsSportTitleIO buf = new NewsSportTitleIO();
                buf.setId(listNewsBO.get(i).getId());
                buf.setTitle(listNewsBO.get(i).getTitle());
                newsSportTitle.getListNewsSportTitle().add(buf);
            }
        }
        return newsSportTitle;
    }

    //автор конкретной новости
    public NewsAuthorIO getNewsAuthorIO(UUID idNews) {
        NewsBO newsBO = newsController.findNewsById(idNews);
        NewsAuthorIO newsAuthor = new NewsAuthorIO();
        newsAuthor.setAuthor(newsBO.getAuthor());
        return newsAuthor;
    }

    //список новостей конкретного автора
    public NewsByAuthorIO getNewsListByAuthorIO(ArrayList<NewsBO> listNewsBO, String author){
        NewsByAuthorIO newsByAuthorIO = new NewsByAuthorIO();
        for (int i = 0; i < listNewsBO.size(); i++) {
            if (listNewsBO.get(i).getAuthor().toUpperCase().equals(author.toUpperCase())){
                NewsIO buf = new NewsIO();
                buf.setId(listNewsBO.get(i).getId());
                buf.setTitle(listNewsBO.get(i).getTitle());
                newsByAuthorIO.getNewsListByAuthorIO().add(buf);
            }
        }
        return newsByAuthorIO;
    }
}
