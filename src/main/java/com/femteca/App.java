package com.femteca;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.repository.AuthorRepositoryImpl;
import com.femteca.repository.BookRepository;
import com.femteca.repository.BookRepositoryImpl;
import com.femteca.repository.GenreRepository;
import com.femteca.repository.GenreRepositoryImpl;
import com.femteca.repository.AuthorRepository;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args ){

        Scanner scanner = new Scanner(System.in);
        try {
            
           
            AuthorRepository authorRepo = new AuthorRepositoryImpl();
            GenreRepository genreRepo = new GenreRepositoryImpl();
            BookRepository bookrepo = new BookRepositoryImpl(genreRepo, authorRepo);

            BookController bookController = new BookController(bookrepo, genreRepo, authorRepo);
            BookView bookView = new BookView(bookController);
            

            bookView.deco();
            bookView.menu(scanner);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
        }

}