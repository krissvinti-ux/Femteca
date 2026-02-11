package com.femteca;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.repository.AuthorRepositoryImpl;
import com.femteca.repository.BookRepository;
import com.femteca.repository.BookRepositoryImpl;
import com.femteca.repository.GenreRepository;
import com.femteca.repository.GenreRepositoryImpl;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args ){

        Scanner scanner = new Scanner(System.in);
        try {
            BookRepository bookrepo = new BookRepositoryImpl();
            AuthorRepositoryImpl authorRepo = new AuthorRepositoryImpl();
            GenreRepository genreRepo = new GenreRepositoryImpl();
            BookController bookController = new BookController(bookrepo, genreRepo);
            BookView bookView = new BookView(bookController, authorRepo);

            bookView.deco();
            bookView.menu(scanner);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
        }

}
