package com.femteca;

import java.util.Scanner;

import com.femteca.controller.BookController;
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
            BookRepository bookRepo = new BookRepositoryImpl();
            GenreRepository genreRepo = new GenreRepositoryImpl();
            BookController bookController = new BookController(bookRepo, genreRepo);
            BookView bookView = new BookView(bookController);
            bookView.deco();
            bookView.menu(scanner);
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
