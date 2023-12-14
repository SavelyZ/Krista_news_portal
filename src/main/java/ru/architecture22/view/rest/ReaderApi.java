package ru.architecture22.view.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.UUID;

import ru.architecture22.IO.*;

@Path("/reader/")
@Produces({ MediaType.APPLICATION_JSON })
public class ReaderApi {
    UUID categoryId1 = UUID.randomUUID();
    UUID categoryId2 = UUID.randomUUID();
    CategoryIO categoryIO1 = new CategoryIO(categoryId1, "Мир");
    CategoryIO categoryIO2 = new CategoryIO(categoryId2, "Спорт");
    AllCategoriesIO allCategoriesIO = new AllCategoriesIO(Arrays.asList(categoryIO1, categoryIO2));

    UUID newsId1 = UUID.randomUUID();
    UUID newsId2 = UUID.randomUUID();
    NewsIO newsIO1 = new NewsIO(newsId1,"Мир", "Новость про мир");
    NewsIO newsIO2 = new NewsIO(newsId2,"Спорт", "Новость про спорт");
    AllNewsIO allNewsIO = new AllNewsIO(Arrays.asList(newsIO1, newsIO2));

    //получить все категории
    @GET
    @Path("/category/all")
    public Response getAllCategories() {
        return Response.ok().entity(allCategoriesIO).build();
    }

    //получить категорию
    @GET
    @Path("/category")
    public Response getOneCategory(@QueryParam("id") UUID id) {
        CategoryIO categoryIO = allCategoriesIO.getListCategories().stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (categoryIO == null) {
            return  Response.status(404).build();
        }
        return  Response.ok().entity(categoryIO).build();
    }

    //получить все заголовки новостей
    @GET
    @Path("/category/news/all")
    public Response getNewsTitles() {
        NewsTitleIO newsTitleIO = new NewsTitleIO();
        for (int i = 0; i < allNewsIO.getListNews().size(); i++){
            String title = allNewsIO.getListNews().get(i).getTitle();
            newsTitleIO.getNewsTitleIO().add(title);
        }
        if (newsTitleIO.getNewsTitleIO().size() > 0) {
            return  Response.ok().entity(newsTitleIO).build();
        }
        return  Response.status(404).build();
    }

    //получить все новости
    @GET
    @Path("/news/all")
    public Response getAllNews() {
        return Response.ok().entity(allNewsIO).build();
    }

    //получить заголовки новостей определенной категории
    @GET
    @Path("/category/news")
    public Response getOneNews(@QueryParam("nameCateg") String nameCategory) {
        NewsTitleIO newsTitleIO = new NewsTitleIO();
        for (int i = 0; i < allNewsIO.getListNews().size(); i++){
            NewsIO news = allNewsIO.getListNews().get(i);
            if (news.getNameCategory().equals(nameCategory)){
                String title = allNewsIO.getListNews().get(i).getTitle();
                newsTitleIO.getNewsTitleIO().add(title);
            }
        }
        if (newsTitleIO.getNewsTitleIO().size() > 0) {
            return  Response.ok().entity(newsTitleIO).build();
        }
        return  Response.status(404).build();
    }
}