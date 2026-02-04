package com.femteca.model;

public class Book {

    private int id;
    private String title;
    private String author;
    private String description;
    private String code;
    private Genre genre;

    public Book (int id, String title, String author, String description, String code, Genre genre ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.code = code;
        this.genre = genre;
    }

    public Book () {

    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
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
