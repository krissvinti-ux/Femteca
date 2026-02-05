package com.femteca.view;

import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Book;

public class BookView {

    private final BookController bookController;

    public BookView (BookController bookController){
        this.bookController = bookController;
    }
    
    public void updateBook(Scanner scan){
        System.out.println("Aqui tienes la lista de libros disponibles : ");
        System.out.print("Ingresa el numero del libro que quieres actualizar : ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Ingresa el nuevo titulo(or press ENTER):  ");
        String title = scan.nextLine();
        System.out.print("Ingresa la nueva descripcion(or press ENTER):  ");
        String description = scan.nextLine();
        System.out.print("Ingresa el nuevo codigo(or press ENTER):  ");
        String code = scan.nextLine();

        Book book = new Book(title, description, code, id);
        
        bookController.updateBook(book);
        System.out.println("libro actualizado correctamente");
    }


}
