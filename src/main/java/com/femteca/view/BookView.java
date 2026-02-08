package com.femteca.view;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Author;
import com.femteca.model.Book;

public class BookView {
    private static final Author Author = null;
    private final BookController bookController;

    public BookView(BookController bookController) {
        this.bookController = bookController;
    }

    public void createBook(Scanner scanner) {
        System.out.println("** Nuevo libro **");
        System.out.println("Ingrese título del libro: ");
        String title = scanner.nextLine();
        System.out.println("Ingrese Nombre y apellido del autor: ");
        String authorName = scanner.nextLine();
        System.out.println("Ingrese descripción del libro (máx. 200 caractéres): ");
        String description = scanner.nextLine();
        System.out.println("Ingrese el código ISBN (xxx-x-xxxxx-xxx-x): ");
        String code = scanner.nextLine();
        // System.out.println("Ingrese género del libro: ");
        // String genre = scanner.nextLine();

        Author author = new Author(authorName);
        Book book = new Book(title, description, code, author);

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
        if (book.getAuthor() != null) {
            System.out.println("Author: " + book.getAuthor().getName());
        } else {
            System.out.println("Author: Unknown");
        }
        System.out.println("Descripción: " + book.getDescription());
        System.out.println("Código: " + book.getCode());
    }

    public void updateBook(Scanner scanner) {
        System.out.println("Aqui tienes la lista de libros disponibles : ");
        System.out.print("Ingresa el numero del libro que quieres actualizar : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingresa el nuevo titulo:  ");
        String title = scanner.nextLine();
        System.out.print("Ingresa el nuevo author:  ");
        String author = scanner.nextLine();
        System.out.print("Ingresa la nueva descripcion(or press ENTER):  ");
        String description = scanner.nextLine();
        System.out.print("Ingresa el nuevo codigo:  ");
        String code = scanner.nextLine();

        Author newAuthor = new Author(author);
        Book book = new Book(title, description, code, newAuthor);

        bookController.updateBook(book);
        System.out.println("libro actualizado correctamente");
    }

    public void deleteBookView(Scanner scanner) {
        System.out.print("Introduce el ID del libro a borrar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bookController.deleteBook(id);
        System.out.println("Libro eliminado correctamente.");
    }
}
