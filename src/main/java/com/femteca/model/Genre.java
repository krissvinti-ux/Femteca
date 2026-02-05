package com.femteca.model;

public class Genre {

    private int id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {}

    public int getNameId() {
        return id;
    }
    public void setNameId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }




    
}
