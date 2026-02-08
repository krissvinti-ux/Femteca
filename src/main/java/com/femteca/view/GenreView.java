package com.femteca.view;

import java.util.Scanner;

import com.femteca.controller.GenreController;
import com.femteca.model.Genre;


public class GenreView {

    private final GenreController genreController;

    public GenreView(GenreController genreController) {
        this.genreController = genreController;
    }

    public void readGenreById(Scanner scanner) {
        System.out.print("Ingresa el ID del genero: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Genre genre = genreController.readGenreById(id);

        if (genre == null) {
            System.out.println("No existe un género con ID: " + id);
            return;
        }

        System.out.println("Género encontrado");
        System.out.println("ID: " + genre.getId());
        System.out.println("Gènero: " + genre.getname());
     
}

}