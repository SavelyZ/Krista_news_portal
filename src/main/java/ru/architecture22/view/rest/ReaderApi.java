package ru.architecture22.view.rest;

import ru.architecture22.IO.CategoryIO;
import ru.architecture22.controller.BO.CategoryBO;
import ru.architecture22.controller.BO.NewsBO;
import ru.architecture22.controller.CategoryController;
import ru.architecture22.controller.Facade;
import ru.architecture22.controller.NewsController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/reader/")
@Produces({ MediaType.APPLICATION_JSON })
public class ReaderApi {
    Facade facade;

    public ReaderApi() {
        NewsController newsController = new NewsController();
        CategoryController categoryController = new CategoryController();
        this.facade = new Facade(newsController, categoryController);
    }

    //получить все категории
    @GET
    @Path("/category/all")
    public Response getAllCategories() {
        List<CategoryBO> responseBO = facade.getListCategory();
        return Response.ok().entity(responseBO).build();
    }

    //получить категорию
    @GET
    @Path("/category")
    public Response getOneCategory(@QueryParam("id") UUID id) {
        CategoryIO categoryIO = facade.getCategoryInformIO(id);
        if (categoryIO == null) {
            return  Response.status(404).build();
        }
        return  Response.ok().entity(categoryIO).build();
    }

    //получить все заголовки новостей
    @GET
    @Path("/category/news/all")
    public Response getNewsTitles() {
        List<String> responseBO = facade.getNewsTitleList();
        return  Response.ok(responseBO).build();
    }

    //получить все новости
    @GET
    @Path("/news/all")
    public Response getAllNews() {
        List<NewsBO> responseBO = facade.getListNews();
        return Response.ok().entity(responseBO).build();
    }

    //получить заголовки новостей определенной категории
    @GET
    @Path("/category/news")
    public Response getOneNews(@QueryParam("nameCateg") String nameCategory) {
        List<NewsBO> responseBO = facade.getNewsByCategory(nameCategory);
        return  Response.ok(responseBO).build();
    }
}