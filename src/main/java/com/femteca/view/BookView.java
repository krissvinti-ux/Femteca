package com.femteca.view;

import java.util.List;
import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Author;
import com.femteca.model.Book;
import com.femteca.model.Colors;

public class BookView {

public void deco () {

    System.err.println(Colors.YELLOW+ "\n____   "+Colors.GREEN+"   ____ "+Colors.BLUE+" ____ "+Colors.YELLOW+"____ "+Colors.PURPLE+"____ "+Colors.CYAN +" ____ "+Colors.WHITE+" ____ "+Colors.GREEN+"____ "+Colors.RED+"____   "+Colors.WHITE+"  ____"+Colors.PURPLE+" ____                                                                                 "+Colors.GREEN+"   ____ "+Colors.BLUE+" ____ "+Colors.YELLOW+"____ "+Colors.PURPLE+"____ "+Colors.CYAN +" ____ "+Colors.WHITE+" ____ "+Colors.GREEN+"____ "+Colors.RED+"____   "+Colors.WHITE+"  ____"+Colors.PURPLE+" ____" + Colors.YELLOW +"____   "+ Colors.RESET );
    System.err.println(Colors.YELLOW+ "\\   \\   "+Colors.GREEN+"  |   |"+Colors.BLUE+" |   |"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|   |"+Colors.CYAN +" |   | "+Colors.WHITE+"|   |"+Colors.GREEN+"|   |"+Colors.RED+"\\   \\  "+Colors.WHITE+"  |   |"+Colors.PURPLE+"|   |" + Colors.WHITE+ "                                                                                " +Colors.GREEN+"  |   |"+Colors.BLUE+" |   |"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|   |"+Colors.CYAN +" |   | "+Colors.WHITE+"|   |"+Colors.GREEN+"|   |"+Colors.RED+"\\   \\  "+Colors.WHITE+"  |   |"+Colors.PURPLE+"|   |"  +Colors.YELLOW+ "\\   \\   "+ Colors.RESET );
    System.err.println(Colors.YELLOW+" \\   \\  "+Colors.GREEN+"  |---|"+Colors.BLUE+" |---|"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|   | "+Colors.CYAN +"|   | "+Colors.WHITE+"|   |"+Colors.GREEN+"|   | "+Colors.RED+"\\---\\  "+Colors.WHITE+" |   |"+Colors.PURPLE+"|   |" + Colors.WHITE+ "      =======  =======  ||\\\\    /|  ========   =======     =====      //\\\\       "+Colors.GREEN+" |   |"+Colors.BLUE+" |   |"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|   |"+Colors.CYAN +" |   | "+Colors.WHITE+"|   |"+Colors.GREEN+"|   |"+Colors.RED+" \\   \\  "+Colors.WHITE+" |   |"+Colors.PURPLE+"|   |" +Colors.YELLOW+ " \\   \\   "+ Colors.RESET);
    System.err.println(Colors.YELLOW+"  \\   \\  "+Colors.GREEN+" |---|"+Colors.BLUE+" |---|"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|---| "+Colors.CYAN +"|   | "+Colors.WHITE+"|---|"+Colors.GREEN+"|   | "+Colors.RED+" \\---\\ "+Colors.WHITE+" |   |"+Colors.PURPLE+"|   |" + Colors.WHITE+ "      |        |        || \\\\  / |     ||      |         //          //  \\\\      "+Colors.GREEN+" |---|"+Colors.BLUE+" |---|"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|   | "+Colors.CYAN +"|   | "+Colors.WHITE+"|   |"+Colors.GREEN+"|   | "+Colors.RED+" \\---\\  "+Colors.WHITE+"|   |"+Colors.PURPLE+"|   |"  +Colors.YELLOW+ "  \\   \\  "+Colors.RESET);
    System.err.println(Colors.YELLOW+"   \\   \\  "+Colors.GREEN+"|   | "+Colors.BLUE+"|   |"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|---| "+Colors.CYAN +"|   |"+Colors.WHITE+" |---|"+Colors.GREEN+"|   | "+Colors.RED+"  \\   \\ "+Colors.WHITE+"|   |"+Colors.PURPLE+"|   |" + Colors.WHITE+ "      |---     |---     ||  \\\\/  |     ||      |---     ||          //----\\\\      "+Colors.GREEN+"|   | "+Colors.BLUE+"|   |"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|---| "+Colors.CYAN +"|   |"+Colors.WHITE+" |---|"+Colors.GREEN+"|   | "+Colors.RED+"  \\   \\ "+Colors.WHITE+"|   |"+Colors.PURPLE+"|   |" + Colors.YELLOW+"   \\   \\  " + Colors.RESET);
    System.err.println(Colors.YELLOW+"    \\   \\ "+Colors.GREEN+"|   | "+Colors.BLUE+"|   |"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|   | "+Colors.CYAN +"|   | "+Colors.WHITE+"|   |"+Colors.GREEN+"|   |  "+Colors.RED+"  \\   \\"+Colors.WHITE+"|   |"+Colors.PURPLE+"|   |" + Colors.WHITE+ "      |        |_____   ||       |     ||      |_____    \\\\_____   //      \\\\     "+Colors.GREEN+"|   | "+Colors.BLUE+"|   |"+Colors.YELLOW+"|   |"+Colors.PURPLE+"|   | "+Colors.CYAN +"|   | "+Colors.WHITE+"|   |"+Colors.GREEN+"|   |  "+Colors.RED+"  \\   \\"+Colors.WHITE+"|   |"+Colors.PURPLE+"|   |" +Colors.YELLOW+"    \\   \\ "+Colors.RESET);
    System.out.println(Colors.BROWN + Colors.BOLD + "==========================================================================================================================================================================================================================" + Colors.RESET);
    System.out.println(" ");
}

public void menu (Scanner scanner) {

    System.out.println("""
        
            MENÚ PRINCIPAL      
                                │ 1. Ver libros               │
                                │ 2. Añadir libro             │
                                │ 3. Editar libro             │
                                │ 4. Eliminar libro           │
                                │ 5. Salir                    │

        """);
    System.out.print("Elige un accion :");
    int mainMenu = scanner.nextInt();
    scanner.nextLine();

    switch (mainMenu) {

        case 1:
            System.out.println("""
        
            VER LIBROS      
                                │ 1. Buscar por título        │
                                │ 2. Buscar por autor         │
                                │ 3. Buscar por género        │
                                │ 4. Volver al menu principal │

        """);
        System.out.print("Elige un accion :");
        int readChoice = scanner.nextInt();
        scanner.nextLine();

            switch (readChoice) {
                case 1:
                    readBookById(scanner);
                case 2:
                    readBookByAuthor(scanner);
                case 3:
                    break;
                case 4:
                    menu(scanner);
                default:
                    System.out.println(Colors.RED + "seleccion invalida, por favor ingresa un numero entre 1 y 4" + Colors.RESET);
                    menu(scanner);
            }
            
            break;

        case 2:
            createBook(scanner);
            menu(scanner);

        case 3:
            updateBook(scanner);
            menu(scanner);

        case 4:
            deleteBookView(scanner);
            menu(scanner);

        case 5:
            break;

        default:
            System.out.println(Colors.RED + "seleccion invalida, por favor ingresa un numero entre 1 y 5");
            menu(scanner);

    }

}


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
        System.out.println(Colors.GREEN + "Libro creado con éxito!" + Colors.RESET);
        menu(scanner);
    }

    public void readBookById(Scanner scanner) {
        System.out.print("Ingresa el ID del libro: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Book book = bookController.readBookById(id);

        if (book == null) {
            System.out.println(Colors.RED + "No existe un libro con ID: " + id  + Colors.RESET);
            menu(scanner);
        }

        System.out.println("Libro encontrado");
        System.out.println(Colors.UNDERLINE + "\nID: " +Colors.RESET+ book.getId());
        System.out.println(Colors.UNDERLINE + "Título: " +Colors.RESET+ book.getTitle());
        if (book.getAuthor() != null) {
            System.out.println(Colors.UNDERLINE + "Autor: " + book.getAuthor().getName());
        } else {
            System.out.println("Autor desconocido");
        }
        System.out.println(Colors.UNDERLINE + "Descripción: "+Colors.RESET + book.getDescription());
        System.out.println(Colors.UNDERLINE + "Código: " + Colors.RESET + book.getCode());

        menu(scanner);
    }

    public void readBookByAuthor(Scanner scanner){

            System.out.print("Ingresa el Author : ");
            String authorName = scanner.nextLine();

            List<Book> books = bookController.readBookByAuthor(authorName);

            if (books.isEmpty()) {
                System.out.println(Colors.RED +"No se encontraron libros para ese autor." + Colors.RESET);
                menu(scanner);
                
            }
            for (Book book : books) {
                System.out.println(Colors.UNDERLINE + "Título: " + Colors.RESET + book.getTitle());
                System.out.println(Colors.UNDERLINE + "Autor: " + Colors.RESET + book.getAuthor().getName());
                System.out.println(Colors.UNDERLINE + "Descripción: " + Colors.RESET + book.getDescription());
                System.out.println(Colors.UNDERLINE + "Código: "  + Colors.RESET+ book.getCode());
}
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
        System.out.println(Colors.GREEN + "libro actualizado correctamente" + Colors.RESET);
        menu(scanner);
    }

    public void deleteBookView(Scanner scanner) {
        System.out.print("Introduce el ID del libro a borrar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bookController.deleteBook(id);
        System.out.println(Colors.GREEN + "Libro eliminado correctamente." + Colors.RESET);
        menu(scanner);
    }}

