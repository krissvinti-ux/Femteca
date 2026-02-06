package com.femteca.repository;

import com.femteca.model.Book;

public interface BookRepository {
    Book readBookById(int id);
}
