package model;

import org.junit.Test;
import ru.architecture22.DO.CategoryDO;
import ru.architecture22.DO.NewsDO;
import ru.architecture22.model.MongoDBProvider;
import ru.architecture22.model.PostgreSQLProvider;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FactoryTest {
    @Test
    public void testFactory() throws IOException {
        MongoDBProvider mongoDBProvider = new MongoDBProvider();
        PostgreSQLProvider postgreSQLProvider = new PostgreSQLProvider();
        mongoDBProvider.make();
        postgreSQLProvider.make();
        ArrayList<NewsDO> listNewsDOMongo = mongoDBProvider.getNewsList();
        ArrayList<NewsDO> listNewsDOPostgre = postgreSQLProvider.getNewsList();
        
        ArrayList<CategoryDO> listCategDOMongo = mongoDBProvider.getCategoriesList();
        ArrayList<CategoryDO> listCategDOPostgre = postgreSQLProvider.getCategoriesList();

        assertEquals(listNewsDOMongo.size(), listNewsDOPostgre.size());
        assertEquals(listCategDOMongo.size(), listCategDOPostgre.size());
    }
}
