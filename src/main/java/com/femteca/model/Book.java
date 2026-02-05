package com.femteca.model;

public class Book {

    private int id;
    private String title;
    private String description;
    private String code;

    public Book (String title, String description, String code, int id) {
        this.title = title;
        this.description = description;
        this.code = code;
        this.id = id;
    }

    public Book () {
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    

}
