package ru.architecture22.view.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import ru.architecture22.IO.AllNewsIO;
import ru.architecture22.IO.NewsByAuthorIO;
import ru.architecture22.IO.NewsIO;

@Path("/writer/")
@Produces({MediaType.APPLICATION_JSON})
public class WriterApi {
    NewsIO fictionNewsIO = new NewsIO(UUID.randomUUID(), "Мир", "Новость про мир", "Петров");
    NewsIO fictionNewsIO2 = new NewsIO(UUID.randomUUID(), "Спорт", "Новость про спорт", "Смирнов");
    AllNewsIO allNewsIO = new AllNewsIO(Arrays.asList(fictionNewsIO, fictionNewsIO2));

    //получить свои новости (по автору)
    @GET
    @Path("/category/news")
    public Response getNewsByAuthor(@QueryParam("author") String author) {
        NewsByAuthorIO newsByAuthorIO = new NewsByAuthorIO();
        for (int i = 0; i < allNewsIO.getListNews().size(); i++) {
            NewsIO news = allNewsIO.getListNews().get(i);
            if (news.getAuthor().equals(author)) {
                newsByAuthorIO.getNewsListByAuthorIO().add(allNewsIO.getListNews().get(i));
            }
        }
        if (newsByAuthorIO.getNewsListByAuthorIO().size() > 0) {
            return Response.ok().entity(newsByAuthorIO).build();
        }
        return Response.status(404).build();
    }

    //добавить новость
    @GET
    @Path("category/news/add_news")
    public Response addNews(@QueryParam("categ") String categ, @QueryParam("title") String title,
                            @QueryParam("author") String author, @QueryParam("text") StringBuilder text) {
        NewsIO newsAdd = new NewsIO(UUID.randomUUID(), categ, title, author, text);
        List<NewsIO> listAuthorNews = new ArrayList<NewsIO>();
        for (int i = 0; i < allNewsIO.getListNews().size(); i++) {
            NewsIO news = allNewsIO.getListNews().get(i);
            if (news.getAuthor().equals(author)) {
                listAuthorNews.add(allNewsIO.getListNews().get(i));
            }
        }
        listAuthorNews.add(newsAdd);
        allNewsIO.getListNews().add(newsAdd);
        if (allNewsIO.getListNews().size() > 0) {
            return  Response.ok().entity(allNewsIO).build();
        }
        return  Response.status(404).build();
    }

    //удалить новость
    @GET
    @Path("/category/news/delete/{id_news}")
    public Response getDeleteNews(@PathParam("id_news") UUID idNews, @QueryParam("author") String author) {
        List<NewsIO> listAuthorNews = new ArrayList<NewsIO>();
        for (int i = 0; i < allNewsIO.getListNews().size(); i++) {
            NewsIO news = allNewsIO.getListNews().get(i);
            if (news.getId().equals(idNews)) {
                allNewsIO.getListNews().remove(i);
            }
            if (news.getAuthor().equals(author)) {
                listAuthorNews.add(allNewsIO.getListNews().get(i));
            }
        }
        for (int i = 0; i < listAuthorNews.size(); i++){
            NewsIO news = listAuthorNews.get(i);
            if (news.getId().equals(idNews)) {
                listAuthorNews.remove(i);
            }
        }
        if (allNewsIO.getListNews() != null) {
            return  Response.ok().entity(allNewsIO).build();
        }
        return  Response.status(404).build();
    }
}