package com.femteca;


import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.repository.BookRepository;
import com.femteca.repository.GenreRepository;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        BookRepository bookRepo = new BookRepositoryImpl();
        GenreRepository genreRepo = new GenreRepositoryImpl();
        BookController bookController = new BookController(bookRepo, genreRepo);
        BookView bookView = new BookView(bookController);
        bookView.updateBook(scan);
        bookView.updateGenre(scan);

        
        
    }
}