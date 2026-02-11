package com.femteca.model;

public class Book {

    private int id;
    private String title;
    private String description;
    private String code;
    private Genre genre;

    public Book(String title, String description, String code, Genre genre) {
        this.title = title;
        this.description = description;
        this.code = code;
        this.genre = genre;
    }

    public Book(String title, String description, String code) {
        this.title = title;
        this.description = description;
        this.code = code;
        
    }

    public Book() {
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

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

   

    public Genre getGenre() {
        return genre;
    }


 
}