package com.femteca.view;

import java.util.Scanner;

import com.femteca.controller.AuthorController;
import com.femteca.model.Author;

public class AuthorView {

    private final AuthorController authorController;

    public AuthorView(AuthorController authorController) {
        this.authorController = authorController;
    }

    public void createAuthor(Scanner scanner) {
        System.out.println("** Nuevo autor **");
        System.out.print("Ingrese nombre del autor: ");
        String name = scanner.nextLine();

        Author author = new Author(name);
        authorController.createAuthor(author);

        System.out.println("Autor creado con éxito!");
    }
}
