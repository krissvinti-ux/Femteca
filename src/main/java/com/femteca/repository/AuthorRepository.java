package com.femteca.repository;

import com.femteca.model.Author;

public interface AuthorRepository {

    Author readAuthor(int id);

    Author createAuthor(Author author);

    Author findByNameAuthor(String name);

}

