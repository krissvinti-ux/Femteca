package com.femteca.repository;

import java.util.List;
import com.femteca.model.Book;

public interface BookRepository {

    void createBook(Book book);

    Book readBookById(int id);

    List<Book> readBookByGenre(String genreName);

    void updateBook(Book book);

    void deleteBook(int id);

    
}
