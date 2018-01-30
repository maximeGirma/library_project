package com.cesi.library_project.database.models;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Category {

    @PrimaryKey(autoIncrement = true)
    private int id;

    private String name;

    public Category() {

    }

    public Category(String name) {
        this();

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
