package com.femteca.view;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Book;

public class BookView {

    private final BookController bookController;

    public BookView(BookController bookController) {
        this.bookController = bookController;
    }

    public void readBookById(Scanner scanner) {
        System.out.print("Ingresa el ID del libro: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book book = bookController.readBookById(id);

        if (book == null) {
            System.out.println("No existe un libro con ID: " + id);
            return;
        }

        System.out.println("Libro encontrado");
        System.out.println("ID: " + book.getId());
        System.out.println("Título: " + book.getTitle());
        System.out.println("Descripción: " + book.getDescription());
        System.out.println("Código: " + book.getCode());
    }
}
