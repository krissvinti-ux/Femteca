package com.femteca;


import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Book;
import com.femteca.repository.BookRepositoryImpl;
import com.femteca.view.BookView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        BookRepositoryImpl repo = new BookRepositoryImpl();
        BookController bookController = new BookController(repo);
        BookView bookView = new BookView(bookController);
        bookView.updateBook(scan);
    }
}
