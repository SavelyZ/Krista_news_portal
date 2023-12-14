package ru.architecture22.controller.BO;

import java.util.ArrayList;
import java.util.UUID;

public class CategoryBO {
    private UUID id;
    private String name;
    private static ArrayList<CategoryBO> listCategoryBO;

    public CategoryBO(){}

    public CategoryBO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListCategoryBO(ArrayList<CategoryBO> listCategoryBO) {
        this.listCategoryBO = listCategoryBO;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<CategoryBO> getListCategoryBO() {
        return listCategoryBO;
    }

}
