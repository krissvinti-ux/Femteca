package com.femteca.controller;


import com.femteca.model.Book;
import com.femteca.repository.BookRepository;

public class BookController {

  private final BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
  public void createBook(Book book){
   bookRepository.createBook(book);
  }

  public Book readBookById(int id) {
        return bookRepository.readBookById(id);
  }

        public void updateBook (Book book) {
        bookRepository.updateBook(book);
  }
  public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }  
}
        


