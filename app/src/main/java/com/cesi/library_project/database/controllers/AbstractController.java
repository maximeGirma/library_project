package com.cesi.library_project.database.controllers;

import com.cesi.library_project.database.models.Category;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractController<A_MODEL_CLASS> implements ICRUD<A_MODEL_CLASS> {

    private LibraryDatabase mLibrary;
    private ObjectModel<A_MODEL_CLASS, ResultSet, HashMap<String, Object>> mProvider;

    protected AbstractController() {

    }

    protected abstract Class<A_MODEL_CLASS> getModelClass();

    @Override
    public void init(LibraryDatabase database) {
        mLibrary = database;
        mProvider = mLibrary.getObjectModel(getModelClass());
    }

    @Override
    public void create(A_MODEL_CLASS model) {
        try {
            mProvider.insert(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<A_MODEL_CLASS> list() {
        try {
            return mProvider.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(A_MODEL_CLASS model) {
        try {
            mProvider.update(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(A_MODEL_CLASS model) {
        try {
            mProvider.delete(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
