package com.femteca.model;

public class Book {
    private String title;
    private String description;
    private String code;

    public Book(String title, String description, String code) {
        this.title = title;
        this.description = description;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }
}
