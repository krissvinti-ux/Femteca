package com.femteca;

import com.femteca.view.BookView;
import com.femteca.controller.BookController;
import com.femteca.controller.AuthorController;
import com.femteca.controller.GenreController;
import com.femteca.model.Book;
import com.femteca.model.Author;
import com.femteca.model.Genre;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

class BookViewTest {

    @Test
    void testReadBookByTitle() {
        BookController bookController = mock(BookController.class);
        AuthorController authorController = mock(AuthorController.class);
        GenreController genreController = mock(GenreController.class);

        BookView view = spy(new BookView(bookController, authorController, genreController));
        doNothing().when(view).menu(any());

        String input = "El Quijote\n";
        Scanner scanner = new Scanner(input);

        Book book = new Book("El Quijote", "Desc", "123");
        book.setId(1);
        book.setAuthor(new Author("Cervantes"));
        book.setGenre(new Genre("Novela"));

        when(bookController.readBookByTitle("El Quijote")).thenReturn(book);

        view.readBookByTitle(scanner);

        verify(bookController).readBookByTitle("El Quijote");
    }
}
