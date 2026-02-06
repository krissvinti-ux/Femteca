package com.femteca.controller;

import com.femteca.repository.BookRepository;

public class BookController {

    private BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    public void deleteBook(int id) {
        repo.deleteBook(id);
    }
}
