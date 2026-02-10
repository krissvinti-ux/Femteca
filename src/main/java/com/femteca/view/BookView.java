package com.femteca.view;

import java.util.List;
import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Book;
import com.femteca.model.Genre;

public class BookView {
    private final BookController bookController;

    public BookView(BookController bookController) {
        this.bookController = bookController;
    }

    public void createBook(Scanner scanner) {
        System.out.println("** Nuevo libro **");
        System.out.print("Ingrese título del libro: ");
        String title = scanner.nextLine();

        System.out.print("Ingrese descripción del libro (máx. 200 caractéres): ");
        String description = scanner.nextLine();

        System.out.print("Ingrese el código ISBN (xxx-x-xxxxx-xxx-x): ");
        String code = scanner.nextLine();

    
     Genre genre =new Genre ();
        Book book = new Book(title, description, code, genre);

        bookController.createBook(book);
        System.out.println("Libro creado con éxito!");
    }

    public void readGenreById(Scanner scanner) {
        System.out.print("¿Qué género quieres leer?: ");
        String genreName = scanner.nextLine();
        List <Book> books= bookController.readBooksByGenre(genreName);

        if (books.isEmpty()) {
            System.out.println("No ingresaste un género.");
            return;
        }

    

        System.out.println("Libros encontrados para el género: " + genreName);
        System.out.println("--------------------------------------------------");

        for (Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Título: " + book.getTitle());

            if (book.getGenre() != null) {
                System.out.println("Género: " + book.getGenre().getname());
            }

            System.out.println("Descripción: " + book.getDescription());
            System.out.println("Código: " + book.getCode());
            System.out.println("--------------------------------------------------");
        }
    }

    public void updateBook(Scanner scanner) {
        System.out.println("Aqui tienes la lista de libros disponibles : ");
        System.out.print("Ingresa el numero del libro que quieres actualizar : ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingresa el nuevo titulo (o ENTER para dejar igual): ");
        String title = scanner.nextLine();

        System.out.print("Ingresa la nueva descripcion (o ENTER para dejar igual): ");
        String description = scanner.nextLine();

        System.out.print("Ingresa el nuevo codigo (o ENTER para dejar igual): ");
        String code = scanner.nextLine();

    
        Book book = new Book(title, description, code, null );
        book.setId(id);

        bookController.updateBook(book);
        System.out.println("Libro actualizado correctamente");
    }

    public void deleteBookView(Scanner scanner) {
        System.out.print("Introduce el ID del libro a borrar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bookController.deleteBook(id);
        System.out.println("Libro eliminado correctamente.");
    }
}
