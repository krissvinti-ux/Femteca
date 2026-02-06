package com.femteca;


import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.repository.BookRepositoryImpl;
import com.femteca.repository.GenreRepositoryImpl;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        BookRepositoryImpl bookRepo = new BookRepositoryImpl();
        GenreRepositoryImpl genreRepo = new GenreRepositoryImpl();
        BookController bookController = new BookController(bookRepo, genreRepo);
        BookView bookView = new BookView(bookController);
        bookView.updateBook(scan);
        bookView.updateGenre(scan);

        
        
    }
}