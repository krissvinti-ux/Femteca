package com.femteca;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.repository.GenreRepository;
import com.femteca.repository.GenreRepositoryImpl;
import com.femteca.repository.BookRepository;
import com.femteca.repository.BookRepositoryImpl;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args ){

        Scanner scanner = new Scanner(System.in);
        try {
            GenreRepository genreRepo = new GenreRepositoryImpl();
            BookRepository bookRepo = new BookRepositoryImpl(genreRepo);
            BookController bookController = new BookController(bookRepo);
            BookView bookView = new BookView(bookController);
            //bookView.createBook(scanner);
            //bookView.updateBook(scanner);
            //bookView.deleteBookView(scanner); 
            bookView.readGenreById(scanner);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
        }

}