package com.cesi.library_project.database.db;

import com.cesi.library_project.database.controllers.CategoryController;

import java.sql.SQLException;

public class DatabaseController {
    private static DatabaseController DATABASE = new DatabaseController();
    private LibraryDatabase mDatabase;

    public static DatabaseController getInstance() {
        return DATABASE;
    }

    private DatabaseController() {
    }

    public void open() {
        try {
            mDatabase = new LibraryDatabase();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        open();

        //call every controller init();
        CategoryController.getInstance().init(mDatabase);
    }
}
