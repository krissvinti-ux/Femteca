package com.femteca;

import java.util.Scanner;

import com.femteca.controller.GenreController;
import com.femteca.repository.GenreRepository;
import com.femteca.repository.GenreRepositoryImpl;

import com.femteca.view.GenreView;

public class App {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

        GenreRepository repo=new GenreRepositoryImpl();
        GenreController controller= new GenreController(repo);
        GenreView view= new GenreView(controller);
        
        view.readGenreById(scanner);
        
        }
         }
          }