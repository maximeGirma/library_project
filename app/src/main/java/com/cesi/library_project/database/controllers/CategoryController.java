package com.cesi.library_project.database.controllers;

import com.cesi.library_project.database.models.Category;
import com.sun.istack.internal.NotNull;

public class CategoryController extends AbstractController<Category> {
    private static final CategoryController CATEGORY_CONTROLLER = new CategoryController();

    public static CategoryController getInstance() {
        return CATEGORY_CONTROLLER;
    }

    private CategoryController() {
        super();
    }

    @NotNull
    @Override
    protected Class<Category> getModelClass() {
        return Category.class;
    }
}
