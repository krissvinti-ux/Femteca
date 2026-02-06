package com.femteca.controller;

import com.femteca.model.Book;
import com.femteca.repository.BookRepository;

public class BookController {

  private final BookRepository bookRepositor;

  public BookController(BookRepository bookRepositor){
   this.bookRepositor = bookRepositor;
  }

  public void createBook(Book book){
   bookRepositor.createBook(book);
  }

}
