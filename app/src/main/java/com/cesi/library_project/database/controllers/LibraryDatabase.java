package com.cesi.library_project.database.controllers;

import com.cesi.library_project.database.models.Category;
import za.co.neilson.sqlite.orm.DatabaseDriverInterface;
import za.co.neilson.sqlite.orm.DatabaseInfo;
import za.co.neilson.sqlite.orm.DatabaseModel;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LibraryDatabase extends DatabaseModel<ResultSet, HashMap<String, Object>> {

    public LibraryDatabase() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        super((Object[]) null);
    }

    @Override
    public ObjectModel<DatabaseInfo, ResultSet, HashMap<String, Object>> onCreateDatabaseInfoModel() throws ClassNotFoundException, NoSuchFieldException {
        return new JdbcObjectModel<DatabaseInfo>(this) {
            //abstract class
        };
    }

    @Override
    protected DatabaseDriverInterface<ResultSet, HashMap<String, Object>> onInitializeDatabaseDriverInterface(Object... objects) {
        return new JdbcSqliteDatabaseDriverInterface(this);
    }

    @Override
    protected void onRegisterObjectModels(HashMap<Type, ObjectModel<?, ResultSet, HashMap<String, Object>>> hashMap) throws ClassNotFoundException, NoSuchFieldException {
        /*
         * Tables Managed By This Model
         */
        // Register the ObjectModel for the Car class with the DatabaseModel
        objectModels.put(Category.class, new JdbcObjectModel<Category>(this) {
        });
    }

    @Override
    public String getDatabaseName() {
        return "library.db";
    }

    @Override
    public int getDatabaseVersion() {
        return 1;
    }

    @Override
    protected void onInsertDefaultValues() {
        Category[] categories = new Category[]{
                new Category("Film"),
                new Category("Musique"),
                new Category("Livre"),
                new Category("Jeux-Vidéo")
        };

        try {
            for (Category category : categories) {
                getObjectModel(Category.class).insert(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
