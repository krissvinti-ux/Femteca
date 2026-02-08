package com.femteca.repository;


import com.femteca.model.Book;

public interface BookRepository {

     void createBook(Book book);

     Book readBookById(int id);
    
     void updateBook(Book book);

     void deleteBook(int id);

    }

