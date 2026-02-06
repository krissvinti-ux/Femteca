package com.femteca.view;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Book;

public class BookView {
    private final BookController bookController;

    public BookView(BookController bookController){
        this.bookController = bookController;
    }

    public void createBook(Scanner scanner){
        System.out.println("** Nuevo libro **");
        System.out.println("Ingrese título del libro: ");
        String title = scanner.nextLine();
        System.out.println("Ingrese Nombre y apellido del autor: ");
        String author = scanner.nextLine();
        System.out.println("Ingrese descripción del libro (máx. 200 caractéres): ");
        String description = scanner.nextLine();
        System.out.println("Ingrese el código ISBN (xxx-x-xxxxx-xxx-x): ");
        String code = scanner.nextLine();
        System.out.println("Ingrese género del libro: ");
        String genre = scanner.nextLine();

        Book book = new Book(title, author, description, code, genre);

        bookController.createBook(book);
        System.out.println("Libro creado con éxito!");
    }
}
