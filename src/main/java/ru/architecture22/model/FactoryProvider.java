package ru.architecture22.model;

import ru.architecture22.DO.*;

import java.util.ArrayList;

public abstract class FactoryProvider implements ProviderInter {
    private static ArrayList<NewsDO> listNewsDO;
    private static ArrayList<CategoryDO> listCategoriesDO;

    @Override
    public ArrayList<NewsDO> getNewsList() {
        return listNewsDO;
    }

    @Override
    public ArrayList<CategoryDO> getCategoriesList() {
        return listCategoriesDO;
    }
}
