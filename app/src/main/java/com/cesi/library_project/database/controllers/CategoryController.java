package com.cesi.library_project.database.controllers;

import com.cesi.library_project.database.models.Category;

public class CategoryController extends AbstractController<Category> {
    private static final CategoryController CATEGORY_CONTROLLER = new CategoryController();

    public static CategoryController getInstance() {
        return CATEGORY_CONTROLLER;
    }

    private CategoryController() {
        super();
    }

    @Override
    protected Class<Category> getModelClass() {
        return Category.class;
    }
}
