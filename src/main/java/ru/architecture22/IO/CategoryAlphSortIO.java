package ru.architecture22.IO;

import ru.architecture22.controller.BO.CategoryBO;

import java.util.ArrayList;

public class CategoryAlphSortIO {
    private CategoryBO categoryBO;
    private ArrayList<CategoryBO> listCategoryBO;

    public ArrayList<CategoryBO> getListCategoryBO() {
        return listCategoryBO;
    }

    public void setListCategoryBO(ArrayList<CategoryBO> listCategoryBO) {
        this.listCategoryBO = listCategoryBO;
    }
}
