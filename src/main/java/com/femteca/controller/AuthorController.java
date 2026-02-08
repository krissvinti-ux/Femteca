package com.femteca.controller;

import com.femteca.model.Author;
import com.femteca.repository.AuthorRepository;

public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void createAuthor(Author author) {
        authorRepository.createAuthor(author);
    }
}
