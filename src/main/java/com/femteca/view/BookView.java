package com.femteca.view;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Book;

public class BookView {
    private final BookController bookController;

    public BookView(BookController bookController) {
        this.bookController = bookController;
    }

    public void createBook(Scanner scanner) {
        System.out.println("** Nuevo libro **");
        System.out.println("Ingrese título del libro: ");
        String title = scanner.nextLine();
        // System.out.println("Ingrese Nombre y apellido del autor: ");
        // String author = scanner.nextLine();
        System.out.println("Ingrese descripción del libro (máx. 200 caractéres): ");
        String description = scanner.nextLine();
        System.out.println("Ingrese el código ISBN (xxx-x-xxxxx-xxx-x): ");
        String code = scanner.nextLine();
        // System.out.println("Ingrese género del libro: ");
        // String genre = scanner.nextLine();

        Book book = new Book(title, description, code);

        bookController.createBook(book);
        System.out.println("Libro creado con éxito!");
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
