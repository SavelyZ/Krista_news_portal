package ru.architecture22.controller;

import ru.architecture22.controller.BO.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface CategoryInter {
    List<CategoryBO> getListCategoryConverted();
    UUID addCategory(UUID id, String name);
    CategoryBO findCategoryByNews(NewsBO newsBO);
    CategoryBO findCategoryByName(String name);
    CategoryBO findCategoryById(UUID id);
    String findCategoryNameById(UUID idCateg);
    void editCategory(String oldName, String newName);
    void delCategory(String name);
}
