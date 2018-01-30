package com.cesi.library_project.database.controllers;

import com.cesi.library_project.database.models.Category;

import java.util.List;

public interface ICRUD<A_MODEL_CLASS> {

    void init(LibraryDatabase database);

    void create(A_MODEL_CLASS model);

    List<A_MODEL_CLASS> list();

    void update(A_MODEL_CLASS model);

    void delete(A_MODEL_CLASS model);

}
