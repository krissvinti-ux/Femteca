package com.femteca.model;

public class Genre {

    private int id;
    private String genre;

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre() {}

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }




    
}
