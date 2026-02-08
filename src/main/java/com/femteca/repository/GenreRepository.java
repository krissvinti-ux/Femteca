package com.femteca.repository;

import com.femteca.model.Genre;

public interface GenreRepository {
    Genre readGenreById(int id);
}
