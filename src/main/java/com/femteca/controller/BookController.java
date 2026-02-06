package com.femteca.controller;

import com.femteca.model.Book;
import com.femteca.repository.BookRepositor;

public class BookController {

  private final BookRepositor bookRepositor;

  public BookController(BookRepositor bookRepositor){
   this.bookRepositor = bookRepositor;
  }

  public void createBook(Book book){
   bookRepositor.createBook(book);
  }

}
