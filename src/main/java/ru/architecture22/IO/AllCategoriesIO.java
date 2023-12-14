package ru.architecture22.IO;

import java.util.List;

public class AllCategoriesIO {
    private List<CategoryIO> listCategories;

    public AllCategoriesIO() {
    }

    public AllCategoriesIO(List<CategoryIO> listCategories) {
        this.listCategories = listCategories;
    }

    public List<CategoryIO> getListCategories() {
        return listCategories;
    }
}
