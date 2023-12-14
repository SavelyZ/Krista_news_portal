package view.rest;

import ru.architecture22.IO.*;
import ru.architecture22.view.WebAppSingletons;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.test.TestPortProvider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ReaderApiTest {
    private static Client client;
    private static UndertowJaxrsServer server;
    private static Response response;
    private static WebTarget categoryResource;
    private static WebTarget newsResource;

    @BeforeClass
    public static void init() {
        client = ClientBuilder.newClient();
        categoryResource = client.target(TestPortProvider.generateURL("/reader/category"));
        newsResource = client.target(TestPortProvider.generateURL("reader/news"));
        server = new UndertowJaxrsServer().start();
        server.deploy(WebAppSingletons.class);
    }

    @AfterClass
    public static void stop() {
        client.close();
        server.stop();
    }

    @Test
    public void getAllCategoriesTest() {
        response = categoryResource.path("/all").request().get();
        AllCategoriesIO allCategoriesIO = response.readEntity(AllCategoriesIO.class);
        assertEquals(2, allCategoriesIO.getListCategories().size());
    }

    @Test
    public void getOneCategoryTest() {
        UUID testId = UUID.randomUUID();
        response = categoryResource.queryParam("id", testId).request().get();
        CategoryIO categoryIO = response.readEntity(CategoryIO.class);
        assertEquals(testId, categoryIO.getId());
    }

    @Test
    public void getNewsTitlesTest() {
        response = categoryResource.path("/news/all").request().get();
        NewsTitleIO newsTitleIO = response.readEntity(NewsTitleIO.class);
        assertEquals("Новость про мир", newsTitleIO.getNewsTitleIO().get(0));
        assertEquals("Новость про спорт", newsTitleIO.getNewsTitleIO().get(1));
    }

    @Test
    public void getAllNewsTest() {
        response = newsResource.path("/all").request().get();
        AllNewsIO allNewsIO = response.readEntity(AllNewsIO.class);
        assertEquals(2, allNewsIO.getListNews().size());
    }

    @Test
    public void getOneNewsTest() {
        UUID testId = UUID.randomUUID();
        response = categoryResource.path("/news").queryParam("id", testId).request().get();
        NewsIO newsIO = response.readEntity(NewsIO.class);
        assertEquals(testId, newsIO.getId());
    }
}