package ru.architecture22.IO;

import ru.architecture22.controller.BO.*;

public class NewsAndCategoryIO {
    private NewsBO newsBO;
    private CategoryBO categoryBO;

    public void setNewsBO(NewsBO newsBO) {
        this.newsBO = newsBO;
    }

    public void setCategoryBO(CategoryBO categoryBO) {
        this.categoryBO = categoryBO;
    }
}
