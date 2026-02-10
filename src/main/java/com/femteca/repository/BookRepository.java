package com.femteca.repository;

import java.util.List;

import com.femteca.model.Book;

public interface BookRepository {

    void createBook(Book book);

    Book readBookById(int id);
    
    void updateBook(Book book);

    void deleteBook(int id);

    List<Book> findAll();
}
