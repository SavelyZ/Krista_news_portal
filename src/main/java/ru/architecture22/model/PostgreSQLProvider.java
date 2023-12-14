package ru.architecture22.model;

import ru.architecture22.DO.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class PostgreSQLProvider extends FactoryProvider{
    private static ArrayList<NewsDO> listNewsDO;
    private static ArrayList<CategoryDO> listCategoriesDO;

    public static void make() throws IOException {
        listCategoriesDO = new ArrayList<>();
        UUID categoryId1 = UUID.randomUUID();
        UUID categoryId2 = UUID.randomUUID();
        CategoryDO categoryDO1 = new CategoryDO(categoryId1, "Мир");
        CategoryDO categoryDO2 = new CategoryDO(categoryId2, "Спорт");
        listCategoriesDO.add(categoryDO1);
        listCategoriesDO.add(categoryDO2);

        listNewsDO = new ArrayList<>();
        UUID authorId1 = UUID.randomUUID();
        UUID authorId2 = UUID.randomUUID();
        String imagePath = "image.jpg";
        BufferedImage image1 = ImageIO.read(new File(imagePath));
        String imagePath2 = "image2.jpg";
        BufferedImage image2 = ImageIO.read(new File(imagePath2));

        NewsDO newsDO1 = new NewsDO(UUID.randomUUID(), categoryId1, "Новость про мир",  new StringBuilder("текст новости1"),
                image1, new Date(), "новая", authorId1);
        NewsDO newsDO2 = new NewsDO(UUID.randomUUID(), categoryId2, "Новость про спорт", new StringBuilder("текст новости2"),
                image2, new Date(), "новая", authorId2);
        listNewsDO.add(newsDO1);
        listNewsDO.add(newsDO2);
    }

    @Override
    public ArrayList<NewsDO> getNewsList() {
        return listNewsDO;
    }

    @Override
    public ArrayList<CategoryDO> getCategoriesList() {
        return listCategoriesDO;
    }
}
