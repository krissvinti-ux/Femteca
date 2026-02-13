package com.femteca.repository;

import com.femteca.model.Genre;


public interface GenreRepository {

    Genre findByName(String name);

    Genre saveGenre(Genre genre);

    Genre readGenreById(int id);
}
