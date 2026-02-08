package com.femteca.controller;

import com.femteca.model.Genre;
import com.femteca.repository.GenreRepository;

public class GenreController {

    private final GenreRepository GenreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.GenreRepository = genreRepository;
    }

    public Genre readGenreById(int id) {
        return GenreRepository.readGenreById(id);
    }
}
