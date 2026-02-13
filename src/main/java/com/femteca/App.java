package com.femteca;

import java.util.Scanner;

import com.femteca.controller.AuthorController;
import com.femteca.controller.BookController;
import com.femteca.controller.GenreController;
import com.femteca.repository.AuthorRepository;
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
            
            AuthorRepository authorRepo = new AuthorRepositoryImpl();
            GenreRepository genreRepo = new GenreRepositoryImpl();
            BookRepository bookRepo = new BookRepositoryImpl(genreRepo, authorRepo);

            BookController bookController = new BookController(bookRepo);
            GenreController genreController = new GenreController(genreRepo);
            AuthorController authorController = new AuthorController(authorRepo);
            BookView bookView = new BookView(bookController, authorController, genreController);
            

            bookView.deco();
            bookView.menu(scanner);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
        }

}