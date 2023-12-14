package ru.architecture22.controller;

import ru.architecture22.DO.CategoryDO;
import ru.architecture22.controller.BO.*;

import java.util.ArrayList;
import java.util.UUID;

public class CategoryController implements CategoryInter {
    public ArrayList<CategoryBO> getListCategory() {
        return null;
    }

    public CategoryBO convertCategDOIntoCategBO(CategoryDO categDO) {
        CategoryBO categBO = new CategoryBO();
        categBO.setId(categDO.getId());
        categBO.setName(categDO.getName());
        return categBO;
    }

    public UUID addCategory(UUID id, String name) {
        CategoryBO categBO = new CategoryBO(id, name);
        categBO.getListCategoryBO().add(categBO);
        return categBO.getId();
    }

    //получение категории для этой новости
    public CategoryBO findCategoryByNews(NewsBO newsBO) {
        CategoryBO categBO = findCategoryByName(newsBO.getNameCategory());
        return categBO;
    }

    public CategoryBO findCategoryByName(String name) {
        for (CategoryBO categBO : CategoryBO.getListCategoryBO()) {
            if (categBO.getName().equals(name)) {
                return categBO;
            }
        }
        return null;
    }

    public CategoryBO findCategoryById(UUID id) {
        for (CategoryBO categBO : CategoryBO.getListCategoryBO()) {
            if (categBO.getId().equals(id)) {
                return categBO;
            }
        }
        return null;
    }

    public String findCategoryNameById(UUID idCateg) {
        for (CategoryBO categBO : CategoryBO.getListCategoryBO()) {
            if (categBO.getId().equals(idCateg)) {
                return categBO.getName();
            }
        }
        return "";
    }

    public void editCategory(String oldName, String newName) {
        CategoryBO categoryBO = this.findCategoryByName(oldName);
        if (categoryBO != null) {
            categoryBO.setName(newName);
        } else {
            System.out.println("Данная категория отсутствует!");
        }
    }

    public void delCategory(String name) {
        CategoryBO categoryBO = this.findCategoryByName(name);
        if (categoryBO != null) {
            CategoryBO.getListCategoryBO().remove(categoryBO);
        } else {
            System.out.println("Данная категория отсутствует!");
        }
    }

}
