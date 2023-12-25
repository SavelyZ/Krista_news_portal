package ru.architecture22.view.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import ru.architecture22.IO.AllNewsIO;
import ru.architecture22.IO.NewsIO;
import ru.architecture22.controller.BO.CategoryBO;
import ru.architecture22.controller.BO.NewsBO;
import ru.architecture22.controller.CategoryController;
import ru.architecture22.controller.Facade;
import ru.architecture22.controller.NewsController;

@Path("/writer/")
@Produces({MediaType.APPLICATION_JSON})
public class WriterApi {

    private Facade facade;

    public WriterApi() {
        NewsController newsController = new NewsController();
        CategoryController categoryController = new CategoryController();
        this.facade = new Facade(newsController, categoryController);
    }

    //получить свои новости (по автору)
    @GET
    @Path("/category/news")
    public Response getNewsByAuthor(@QueryParam("author") String author) {
        List<NewsBO> responseBO = facade.getNewsListByAuthor(author);
        return Response.ok(responseBO).build();
    }

    //добавить новость
    @GET
    @Path("category/news/add_news")
    public Response addNews(@QueryParam("categId") UUID categId, @QueryParam("title") String title,
                            @QueryParam("author") String author, @QueryParam("text") StringBuilder text) {
        CategoryBO categoryBO = facade.findCategoryById(categId);
        facade.addNews(title, text, categoryBO, null);
        return Response.ok().build();
    }

    //удалить новость
    @GET
    @Path("/category/news/delete/{id_news}")
    public Response deleteNews(@PathParam("id_news") UUID idNews) {
        facade.delNews(idNews);
        return  Response.status(404).build();
    }
}