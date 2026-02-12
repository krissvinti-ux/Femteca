package com.femteca.model;

public class Genre {

  private int id;
  private String name;

  public Genre(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Genre(String name) {
    this.name = name;

  }

  public Genre() {

  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setname(String name) {
    this.name = name;
  }

  public String getname() {
    return name;
  }
}