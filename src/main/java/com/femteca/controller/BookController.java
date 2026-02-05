package com.femteca.controller;

import com.femteca.model.Book;
import com.femteca.repository.BookRepository;

public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void updateBook (Book book) {
        bookRepository.updateBook(book);
    }
        
};

