package com.femteca.view;

import java.util.Scanner;
import com.femteca.controller.BookController;

public class BookView {

    private BookController controller;

    public BookView(BookController controller) {
        this.controller = controller;
    }

    public void deleteBookView() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el ID del libro a borrar: ");
        int id = sc.nextInt();
        sc.close();

        controller.deleteBook(id);
        System.out.println("Libro eliminado correctamente.");
    }
}
