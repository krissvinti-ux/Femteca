package com.femteca.view;
import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Book;
import com.femteca.repository.AuthorRepositoryImpl;
import com.femteca.model.Author;


public class BookView {
    private final BookController bookController;
    private final AuthorRepositoryImpl authorRepositoryImpl;

    public BookView(BookController bookController, AuthorRepositoryImpl authorRepositoryImpl) {
        this.bookController = bookController;
        this.authorRepositoryImpl = authorRepositoryImpl;

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
        authorRepositoryImpl.createAuthor(author);
        Book book = new Book(title, description, code, author);

        
        //book.setAuthor(author);
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

    
    public void updateBook(Scanner scanner){
        System.out.println("Aqui tienes la lista de libros disponibles : ");


        System.out.print("Ingresa el numero del libro que quieres actualizar : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingresa el nuevo titulo(or press ENTER):  ");
        String title = scanner.nextLine();
 

        System.out.print("Ingresa la nueva descripcion(or press ENTER):  ");
        String description = scanner.nextLine();

        System.out.print("Ingresa el nuevo codigo(or press ENTER):  ");
        String code = scanner.nextLine();
        
        Book book = new Book(title, description, code);
        book.setId(id);

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
