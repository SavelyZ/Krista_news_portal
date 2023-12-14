package view.rest;

import ru.architecture22.IO.AllNewsIO;
import ru.architecture22.IO.NewsByAuthorIO;
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

import static org.junit.Assert.assertEquals;

public class WriterApiTest {
    private static Client client;
    private static UndertowJaxrsServer server;
    private static Response response;
    private static WebTarget categoryResource;
    private static WebTarget newsResource;

    @BeforeClass
    public static void init() {
        client = ClientBuilder.newClient();
        categoryResource = client.target(TestPortProvider.generateURL("/writer/category"));
        newsResource = client.target(TestPortProvider.generateURL("writer/news"));
        server = new UndertowJaxrsServer().start();
        server.deploy(WebAppSingletons.class);
    }

    @AfterClass
    public static void stop() {
        client.close();
        server.stop();
    }

    @Test
    public void getNewsByAuthorTest() {
        response = categoryResource.path("/news").queryParam("author", "Петров").request().get();
        NewsByAuthorIO newsByAuthorIO = response.readEntity(NewsByAuthorIO.class);
        assertEquals(1, newsByAuthorIO.newsListByAuthorIO.size());
    }

    @Test
    public void addNewsTest() {
        response = categoryResource.path("/news/add_news").queryParam("categ", "Мир").
                queryParam("title", "Новость про мир2").queryParam("Алексадров").
                queryParam("text", new StringBuilder("текст новости")).request().get();
        AllNewsIO allNewsIO = response.readEntity(AllNewsIO.class);
        assertEquals(3, allNewsIO.getListNews().size());
        assertEquals("Мир", allNewsIO.getListNews().get(2).getNameCategory());
        assertEquals("Новость про мир2", allNewsIO.getListNews().get(2).getTitle());
        assertEquals("Александров", allNewsIO.getListNews().get(2).getAuthor());
        assertEquals("текст новости", allNewsIO.getListNews().get(2).getText());
    }

    @Test
    public void getDeleteNewsTest() {
        response = categoryResource.path("/news/delete/{id_news}").queryParam("author", "Петров").
                request().get();
        AllNewsIO allNewsIO = response.readEntity(AllNewsIO.class);
        assertEquals(1, allNewsIO.getListNews().size());
    }
}