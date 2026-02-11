package com.femteca.controller;



import com.femteca.model.Book;
import com.femteca.model.Genre;
import com.femteca.repository.BookRepository;
import com.femteca.repository.GenreRepository;

public class BookController {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    public BookController(BookRepository bookRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
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

    public Genre createGenre(String name) {
        Genre genre = new Genre();
        genre.setGenre(name);
        return genreRepository.saveGenre(genre);
    }

    public Genre getGenreByName(String name) {
        return genreRepository.findByName(name);
    }
}
