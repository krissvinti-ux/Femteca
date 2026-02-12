package com.femteca.view;

import java.util.List;
import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Author;
import com.femteca.model.Book;
import com.femteca.model.Genre;
import com.femteca.model.Colors;

public class BookView {

    private final BookController bookController;

    public BookView(BookController bookController) {
        this.bookController = bookController;
    }

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
                                │ 1. Ver todos los libros     │
                                │ 2. Buscar por título        │
                                │ 3. Buscar por autor         │
                                │ 4. Buscar por género        │
                                │ 5. Volver al menu principal │

        """);
        System.out.print("Elige un accion :");
        int readChoice = scanner.nextInt();
        scanner.nextLine();

            switch (readChoice) {
                case 1 : 
                    showAllBooks();
                    System.out.print(Colors.BOLD + "\nPressiona el ENTER para volver al menu " + Colors.RESET);
                    scanner.nextLine();
                    menu(scanner);
                case 2:
                    readBookByTitle(scanner);
                    System.out.print(Colors.BOLD + "\nPressiona el ENTER para volver al menu " + Colors.RESET);
                    scanner.nextLine();
                    menu(scanner);
                case 3:
                    readBookByAuthor(scanner);
                    System.out.print(Colors.BOLD + "\nPressiona el ENTER para volver al menu " + Colors.RESET);
                    scanner.nextLine();
                    menu(scanner);
                case 4:
                    readGenreById(scanner);
                    System.out.print(Colors.BOLD + "\nPressiona el ENTER para volver al menu " + Colors.RESET);
                    scanner.nextLine();
                    menu(scanner);
                case 5:
                    menu(scanner);
                default:
                    System.out.println(Colors.RED + "seleccion invalida, por favor ingresa un numero entre 1 y 4" + Colors.RESET);
                    menu(scanner);
            }
            
            break;

        case 2:
            createBook(scanner);
            System.out.print(Colors.BOLD + "\nPressiona el ENTER para volver al menu " + Colors.RESET);
            scanner.nextLine();
            menu(scanner);

        case 3:
            updateBook(scanner);
            System.out.print(Colors.BOLD + "\nPressiona el ENTER para volver al menu " + Colors.RESET);
            scanner.nextLine();
            menu(scanner);

        case 4:
            deleteBookView(scanner);
            System.out.print(Colors.BOLD + "\nPressiona el ENTER para volver al menu " + Colors.RESET);
            scanner.nextLine();
            menu(scanner);

        case 5:
            menu(scanner);

        default:
            System.out.println(Colors.RED + "seleccion invalida, por favor ingresa un numero entre 1 y 5");
            menu(scanner);

        }
    }

    public void createBook(Scanner scanner) {
        System.out.println("** Nuevo libro **");
        System.out.println("\n--------------------");
        System.out.println("\nIngrese título del libro: ");
        String title = scanner.nextLine();
        System.out.println("Ingrese Nombre y apellido del autor: ");
        String authorName = scanner.nextLine();
        Author author = bookController.findByNameAuthor(authorName);
            if (author == null) {
            author = new Author(authorName); 
            author.setName(authorName);
            author = bookController.createAuthor(author);
            System.out.println(Colors.GREEN + "Autor creado con éxito!" + Colors.RESET);
        }
        
        System.out.println("Ingrese descripción del libro (máx. 200 caractéres): ");
        String description = scanner.nextLine();

        System.out.println("Ingrese el código ISBN (xxx-x-xxxxx-xxx-x): ");
        String code = scanner.nextLine();

        System.out.println("Ingrese género del libro: ");
        String genreName = scanner.nextLine();
        Genre genre = bookController.getGenreByName(genreName);
        if (genre == null) {
            genre = new Genre(genreName);
            genre.setname(genreName);
            genre = bookController.createGenre(genre);
            System.out.println(Colors.GREEN + "Género creado con éxito!" + Colors.RESET);
        }

        Book book = new Book(title, description, code);
        book.setGenre(genre);
        book.setAuthor(author);
        bookController.createBook(book);
        System.out.println("\n--------------------");
        System.out.println(Colors.GREEN + "\nLibro creado con éxito!" + Colors.RESET);
        System.out.println("\n--------------------");
        menu(scanner);
    }

    public void readGenreById(Scanner scanner) {
        System.out.print("¿Qué género quieres leer?: ");
        String genreName = scanner.nextLine();
        List<Book> books = bookController.readBooksByGenre(genreName);

        if (books.isEmpty()) {
            System.out.println("No ingresaste un género.");
            return;
        }

        System.out.println("Libros encontrados para el género: " + genreName);

        for (Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Título: " + book.getTitle());

            if (book.getGenre() != null) {
                System.out.println("Género: " + book.getGenre().getname());
            }
            if (book.getAuthor() != null) {
                System.out.println("Author " + book.getAuthor().getName());
            }

            System.out.println("Descripción: " + book.getDescription());
            System.out.println("Código: " + book.getCode());
            System.out.println("--------------------------------------------------");
        }


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
                System.out.println("Título: " +  book.getTitle());
                System.out.println("Autor: " +  book.getAuthor().getName());
                // System.out.println("Genero: " + book.getGenre().getname());
                System.out.println("Descripción: " +  book.getDescription());
                System.out.println("Código: "  + book.getCode());
                System.out.println("\n--------------------");
}
        }

    public void updateBook(Scanner scanner) {
        System.out.print("\nIngresa el numero del libro que quieres actualizar : ");
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
        System.out.println(id);
        Book book = bookController.readBookById(id);
        System.out.println(book.getId());
        
        book.setTitle(title);
        book.setCode(code);
        book.setDescription(description);
        book.setAuthor(newAuthor);

        bookController.updateBook(book);
        System.out.println("\n--------------------");
        System.out.println(Colors.GREEN + "libro actualizado correctamente" + Colors.RESET);
        System.out.println("\n--------------------");
        menu(scanner);
    }

    public void deleteBookView(Scanner scanner) {

        System.out.print("Introduce el numero del libro a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bookController.deleteBook(id);
        System.out.println("\n--------------------");
        System.out.println(Colors.GREEN + "Libro eliminado correctamente." + Colors.RESET);
        System.out.println("\n--------------------");
        menu(scanner);
    }

    public void showAllBooks() {

    List<Book> books = bookController.readAllBooks();

    if (books.isEmpty()) {
        System.out.println("No hay libros registrados.");
        return;
    }

    System.out.println("Lista de libros:");
    System.out.println("------------------");

    for (Book book : books) {
        System.out.println("ID: " + book.getId());
        System.out.println("Título: " + book.getTitle());

        if (book.getAuthor() != null) {
            System.out.println("Autor: " + book.getAuthor().getName());
        } else {
            System.out.println("Autor desconocido");
        }
        if (book.getGenre() != null) {
            System.out.println("Genre: " + book.getGenre().getname());
        } else {
            System.out.println("Genre desconocido");
        }
        System.out.println("Código: " + book.getCode());
        System.out.println("------------------");
    }
}

public void readBookById(Scanner scanner) {}

public void readBookByTitle(Scanner scanner) {

        System.out.print("Ingresa el titulo del Libro : ");
        String title = scanner.nextLine();

        Book book = bookController.readBookByTitle(title);

        if (book == null ) {
        System.out.println(Colors.RED + "No hay libros registrado con este titulo" +Colors.RESET);
        menu(scanner);
    }

        System.out.println("\nID: " +book.getId());
        System.out.println("Título: " +book.getTitle());
        if (book.getAuthor() != null) {
            System.out.println("Autor: " + book.getAuthor().getName());
        } else {
            System.out.println("Autor desconocido");
        }
        if (book.getGenre() != null) {
            System.out.println("Genre: " + book.getGenre().getname());
        } else {
            System.out.println("Genre desconocido");
        }
        System.out.println("Descripción: "+ book.getDescription());
        System.out.println("Código: " + book.getCode());

        System.out.println("--------------------------------------------------");
}
}

