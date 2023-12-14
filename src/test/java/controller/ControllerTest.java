package controller;

import org.junit.Test;
import ru.architecture22.controller.BO.CategoryBO;
import ru.architecture22.controller.BO.NewsBO;
import ru.architecture22.controller.CategoryController;
import ru.architecture22.controller.NewsController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import static org.junit.Assert.assertEquals;

public class ControllerTest {

    @Test
    public void addCategTest() {
        UUID categoryAddId = UUID.randomUUID();
        CategoryController categoryController = new CategoryController();
        categoryController.addCategory(categoryAddId, "Мир");
        CategoryBO findCateg = categoryController.findCategoryById(categoryAddId);
        assertEquals(categoryAddId, findCateg.getId());
    }

    @Test
    public void addNewsTest() throws IOException {
        UUID newsAddId = UUID.randomUUID();
        NewsController newsController = new NewsController();
        String imagePath = "image.jpg";
        BufferedImage image1 = ImageIO.read(new File(imagePath));
        newsController.addNews(newsAddId, "Мир", new StringBuilder("текст новости"), "Мир",  image1);
        NewsBO findNews = newsController.findNewsById(newsAddId);
        assertEquals(newsAddId, findNews.getId());
    }
}
