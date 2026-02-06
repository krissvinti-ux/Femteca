package com.femteca;

import java.util.Scanner;

import com.femteca.controller.BookController;

import com.femteca.repository.BookRepository;
import com.femteca.repository.BookRepositoryImpl;

import com.femteca.view.BookView;

public class App {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            BookRepository repo = new BookRepositoryImpl();
            BookController controller = new BookController(repo);
            BookView view = new BookView(controller);

            view.readBookById(scanner);
        }
    }
}
