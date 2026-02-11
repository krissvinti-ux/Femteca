package com.femteca;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.repository.AuthorRepositoryImpl;
import com.femteca.repository.BookRepository;
import com.femteca.repository.BookRepositoryImpl;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args ){

        Scanner scanner = new Scanner(System.in);
        try {
            BookRepository repo = new BookRepositoryImpl();
            AuthorRepositoryImpl authorRepo = new AuthorRepositoryImpl();
            BookController bookController = new BookController(repo);
            BookView bookView = new BookView(bookController, authorRepo);
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
