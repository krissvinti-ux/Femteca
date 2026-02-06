package com.femteca.controller;

import com.femteca.model.Genre;
import com.femteca.repository.GenreRepository;

public class BookController {

    private final GenreRepository genreRepository;

    public BookController(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
    }

    public void updateGenre (Genre genre) {
        genreRepository.updateGenre(genre);
    }
        
};
