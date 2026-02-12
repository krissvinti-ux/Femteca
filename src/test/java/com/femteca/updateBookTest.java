package com.femteca;

import com.femteca.model.Author;
import com.femteca.model.Book;
import com.femteca.model.Genre;

import com.femteca.repository.GenreRepository;
import com.femteca.repository.GenreRepositoryImpl;
import com.femteca.repository.AuthorRepository;
import com.femteca.repository.AuthorRepositoryImpl;
import com.femteca.repository.BookRepository;
import com.femteca.repository.BookRepositoryImpl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class updateBookTest {

    @Test
    void testUpdateBook() {

        GenreRepository genreRepo = new GenreRepositoryImpl();
        AuthorRepository authorRepo = new AuthorRepositoryImpl();
        BookRepository repo = new BookRepositoryImpl(genreRepo, authorRepo);

        Author author = new Author("Cervantes");
        authorRepo.createAuthor(author);

        Genre genre = new Genre("Novela");
        genreRepo.saveGenre(genre);   

        Book book = new Book("Titulo viejo", "Desc vieja", "111", author, genre);
        repo.createBook(book);

        book.setTitle("Titulo nuevo");
        book.setDescription("Desc nueva");
        book.setCode("999");

        repo.updateBook(book);

        Book updated = repo.readBookById(book.getId());

        assertEquals("Titulo nuevo", updated.getTitle());
        assertEquals("Desc nueva", updated.getDescription());
        assertEquals("999", updated.getCode());
    }
}
