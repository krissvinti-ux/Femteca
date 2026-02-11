package com.femteca;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.repository.GenreRepository;
import com.femteca.repository.GenreRepositoryImpl;
import com.femteca.repository.BookRepository;
import com.femteca.repository.BookRepositoryImpl;
//import com.femteca.repository.GenreRepository;
//import com.femteca.repository.GenreRepositoryImpl;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args ){

        Scanner scanner = new Scanner(System.in);
        try {
            GenreRepository genreRepo = new GenreRepositoryImpl();
            BookRepository bookRepo = new BookRepositoryImpl(genreRepo);
           // BookController bookController = new BookController(bookRepo);
            BookController bookController = new BookController(bookRepo, genreRepo);
            
            //bookView.deleteBookView(scanner); 
           

            BookView bookView = new BookView(bookController);
            bookView.deco();
            bookView.menu(scanner);
            bookView.readGenreById(scanner);
            // bookView.createBook(scanner);
            // bookView.readBookById(scanner);
            // bookView.updateBook(scanner);
            // bookView.deleteBookView(scanner); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
        }

}