package ru.architecture22.model;

import ru.architecture22.DO.*;

import java.util.ArrayList;

public interface ProviderInter {
    void make() throws Exception;
    ArrayList<NewsDO> getNewsList();
    ArrayList<CategoryDO> getCategoriesList();
}
