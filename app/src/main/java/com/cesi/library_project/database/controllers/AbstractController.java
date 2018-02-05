package com.cesi.library_project.database.controllers;

import com.cesi.library_project.database.db.LibraryDatabase;
import com.sun.istack.internal.NotNull;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Generic class which takes a class in parameters and manage all the CRUDs operations
 *
 * It is mandatory to extends it using extends AbstractController<class name like Category>
 *
 * @param <A_MODEL_CLASS> the class name which will be used
 */
public abstract class AbstractController<A_MODEL_CLASS> implements ICRUD<A_MODEL_CLASS> {

    //the current database instance
    private LibraryDatabase mLibrary;

    //the class instances provider
    private ObjectModel<A_MODEL_CLASS, ResultSet, HashMap<String, Object>> mProvider;

    //we protect the standard constructor
    protected AbstractController() {

    }

    /**
     * Get the Class used to implements instances
     * @return the Class to use to implements instances
     */
    @NotNull
    protected abstract Class<A_MODEL_CLASS> getModelClass();

    /**
     * Init the current Controller
     * Mandatory to call it after the database initialisation
     *
     * @param database
     */
    @Override
    public void init(@NotNull LibraryDatabase database) {
        mLibrary = database;
        mProvider = mLibrary.getObjectModel(getModelClass());
    }

    /**
     * Create a specific instance in the database
     *
     * @param model the model to save in the database
     */
    @Override
    public void create(@NotNull A_MODEL_CLASS model) {
        try {
            mProvider.insert(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieve every object models from the dabase
     *
     * @return a non null list
     */
    @NotNull
    @Override
    public List<A_MODEL_CLASS> list() {
        try {
            return mProvider.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update the given model into the database
     *
     * @param model the model to update
     */
    @Override
    public void update(@NotNull A_MODEL_CLASS model) {
        try {
            mProvider.update(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a given model from the database
     *
     * @param model the existing model
     */
    @Override
    public void delete(@NotNull A_MODEL_CLASS model) {
        try {
            mProvider.delete(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
