package com.femteca.controller;

import com.femteca.repository.GenreRepository;

import com.femteca.model.Genre;

public class GenreController {
    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.saveGenre(genre);
    }

    public Genre getGenreByName(String name) {
        return genreRepository.findByName(name);
    }
}
