package com.femteca;

import com.femteca.repository.BookRepositoryImpl;
import com.femteca.controller.BookController;
import com.femteca.view.BookView;

public class App 
{
    public static void main( String[] args )
    {
        BookRepositoryImpl repo = new BookRepositoryImpl();

        BookController controller = new BookController(repo);
        BookView view = new BookView(controller);

        view.deleteBookView();  // Ejecuta solo borrar
    }
}
