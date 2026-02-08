package com.femteca;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.repository.AuthorRepository;
import com.femteca.repository.AuthorRepositoryImpl;
import com.femteca.repository.BookRepository;
import com.femteca.repository.BookRepositoryImpl;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        try {
            AuthorRepository authorRepo = new AuthorRepositoryImpl();
            BookRepository bookRepo = new BookRepositoryImpl(authorRepo);
            BookController bookController = new BookController(bookRepo);
            BookView bookView = new BookView(bookController);
            // bookView.createBook(scanner);
            // bookView.readBookById(scanner);
            bookView.readBookByAuthor();
            bookView.updateBook(scanner);
            bookView.deleteBookView(scanner); 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
        }

}
