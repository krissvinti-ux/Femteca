package com.femteca.controller;

import com.femteca.model.Genre;
import com.femteca.repository.BookRepository;
import com.femteca.repository.GenreRepository;

public class BookController {

    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository, GenreRepository genreRepository) {
    this.bookRepository = bookRepository;
    this.genreRepository = genreRepository;
    }

    public void updateGenre (Genre genre) {
        genreRepository.updateGenre(genre);
    }
        
};
