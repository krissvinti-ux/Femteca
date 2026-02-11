package com.femteca.controller;

import java.util.List;
import com.femteca.model.Book;
import com.femteca.model.Genre;
import com.femteca.repository.AuthorRepository;
import com.femteca.repository.BookRepository;
import com.femteca.repository.GenreRepository;
import com.femteca.model.Author;;

public class BookController {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, GenreRepository genreRepository,
            AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }

    public void createBook(Book book) {
        bookRepository.createBook(book);
    }

    public Book readBookById(int id) {
        return bookRepository.readBookById(id);
    }

    public void updateBook(Book book) {
        bookRepository.updateBook(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteBook(id);
    }

    public List<Book> readBooksByGenre(String genreName) {
        return bookRepository.readBookByGenre(genreName);
    }

    public Genre createGenre(Genre genre) {
        return genreRepository.saveGenre(genre);
    }

    public Genre getGenreByName(String name) {
        return genreRepository.findByName(name);
    }

    public void createAuthor(Author author) {
        authorRepository.createAuthor( author);

    }
}
