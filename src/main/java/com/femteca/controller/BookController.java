package com.femteca.controller;

import com.femteca.model.Book;
import com.femteca.repository.BookRepository;

public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book readBookById(int id) {
        return bookRepository.readBookById(id);
    }
}
