package com.femteca.view;

import java.util.List;
import java.util.Scanner;

import com.femteca.controller.BookController;
import com.femteca.model.Book;
//import com.femteca.repository.AuthorRepositoryImpl;
import com.femteca.model.Author;

import com.femteca.model.Genre;
import com.femteca.model.Colors;

public class BookView {

    public void deco() {

        System.err.println(Colors.YELLOW + "\n____   " + Colors.GREEN + "   ____ " + Colors.BLUE + " ____ "
                + Colors.YELLOW + "____ " + Colors.PURPLE + "____ " + Colors.CYAN + " ____ " + Colors.WHITE + " ____ "
                + Colors.GREEN + "____ " + Colors.RED + "____   " + Colors.WHITE + "  ____" + Colors.PURPLE
                + " ____                                                                                 "
                + Colors.GREEN + "   ____ " + Colors.BLUE + " ____ " + Colors.YELLOW + "____ " + Colors.PURPLE + "____ "
                + Colors.CYAN + " ____ " + Colors.WHITE + " ____ " + Colors.GREEN + "____ " + Colors.RED + "____   "
                + Colors.WHITE + "  ____" + Colors.PURPLE + " ____" + Colors.YELLOW + "____   " + Colors.RESET);
        System.err.println(Colors.YELLOW + "\\   \\   " + Colors.GREEN + "  |   |" + Colors.BLUE + " |   |"
                + Colors.YELLOW + "|   |" + Colors.PURPLE + "|   |" + Colors.CYAN + " |   | " + Colors.WHITE + "|   |"
                + Colors.GREEN + "|   |" + Colors.RED + "\\   \\  " + Colors.WHITE + "  |   |" + Colors.PURPLE + "|   |"
                + Colors.WHITE + "                                                                                "
                + Colors.GREEN + "  |   |" + Colors.BLUE + " |   |" + Colors.YELLOW + "|   |" + Colors.PURPLE + "|   |"
                + Colors.CYAN + " |   | " + Colors.WHITE + "|   |" + Colors.GREEN + "|   |" + Colors.RED + "\\   \\  "
                + Colors.WHITE + "  |   |" + Colors.PURPLE + "|   |" + Colors.YELLOW + "\\   \\   " + Colors.RESET);
        System.err.println(Colors.YELLOW + " \\   \\  " + Colors.GREEN + "  |---|" + Colors.BLUE + " |---|"
                + Colors.YELLOW + "|   |" + Colors.PURPLE + "|   | " + Colors.CYAN + "|   | " + Colors.WHITE + "|   |"
                + Colors.GREEN + "|   | " + Colors.RED + "\\---\\  " + Colors.WHITE + " |   |" + Colors.PURPLE + "|   |"
                + Colors.WHITE + "      =======  =======  ||\\\\    /|  ========   =======     =====      //\\\\       "
                + Colors.GREEN + " |   |" + Colors.BLUE + " |   |" + Colors.YELLOW + "|   |" + Colors.PURPLE + "|   |"
                + Colors.CYAN + " |   | " + Colors.WHITE + "|   |" + Colors.GREEN + "|   |" + Colors.RED + " \\   \\  "
                + Colors.WHITE + " |   |" + Colors.PURPLE + "|   |" + Colors.YELLOW + " \\   \\   " + Colors.RESET);
        System.err.println(Colors.YELLOW + "  \\   \\  " + Colors.GREEN + " |---|" + Colors.BLUE + " |---|"
                + Colors.YELLOW + "|   |" + Colors.PURPLE + "|---| " + Colors.CYAN + "|   | " + Colors.WHITE + "|---|"
                + Colors.GREEN + "|   | " + Colors.RED + " \\---\\ " + Colors.WHITE + " |   |" + Colors.PURPLE + "|   |"
                + Colors.WHITE + "      |        |        || \\\\  / |     ||      |         //          //  \\\\      "
                + Colors.GREEN + " |---|" + Colors.BLUE + " |---|" + Colors.YELLOW + "|   |" + Colors.PURPLE + "|   | "
                + Colors.CYAN + "|   | " + Colors.WHITE + "|   |" + Colors.GREEN + "|   | " + Colors.RED + " \\---\\  "
                + Colors.WHITE + "|   |" + Colors.PURPLE + "|   |" + Colors.YELLOW + "  \\   \\  " + Colors.RESET);
        System.err.println(Colors.YELLOW + "   \\   \\  " + Colors.GREEN + "|   | " + Colors.BLUE + "|   |"
                + Colors.YELLOW + "|   |" + Colors.PURPLE + "|---| " + Colors.CYAN + "|   |" + Colors.WHITE + " |---|"
                + Colors.GREEN + "|   | " + Colors.RED + "  \\   \\ " + Colors.WHITE + "|   |" + Colors.PURPLE + "|   |"
                + Colors.WHITE
                + "      |---     |---     ||  \\\\/  |     ||      |---     ||          //----\\\\      "
                + Colors.GREEN + "|   | " + Colors.BLUE + "|   |" + Colors.YELLOW + "|   |" + Colors.PURPLE + "|---| "
                + Colors.CYAN + "|   |" + Colors.WHITE + " |---|" + Colors.GREEN + "|   | " + Colors.RED + "  \\   \\ "
                + Colors.WHITE + "|   |" + Colors.PURPLE + "|   |" + Colors.YELLOW + "   \\   \\  " + Colors.RESET);
        System.err.println(Colors.YELLOW + "    \\   \\ " + Colors.GREEN + "|   | " + Colors.BLUE + "|   |"
                + Colors.YELLOW + "|   |" + Colors.PURPLE + "|   | " + Colors.CYAN + "|   | " + Colors.WHITE + "|   |"
                + Colors.GREEN + "|   |  " + Colors.RED + "  \\   \\" + Colors.WHITE + "|   |" + Colors.PURPLE + "|   |"
                + Colors.WHITE
                + "      |        |_____   ||       |     ||      |_____    \\\\_____   //      \\\\     "
                + Colors.GREEN + "|   | " + Colors.BLUE + "|   |" + Colors.YELLOW + "|   |" + Colors.PURPLE + "|   | "
                + Colors.CYAN + "|   | " + Colors.WHITE + "|   |" + Colors.GREEN + "|   |  " + Colors.RED + "  \\   \\"
                + Colors.WHITE + "|   |" + Colors.PURPLE + "|   |" + Colors.YELLOW + "    \\   \\ " + Colors.RESET);
        System.out.println(Colors.BROWN + Colors.BOLD
                + "=========================================================================================================================================================================================================================="
                + Colors.RESET);
        System.out.println(" ");
    }

    public void menu(Scanner scanner) {

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
                        readGenreById(scanner);
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        menu(scanner);
                    default:
                        System.out.println("\n--------------------");
                        System.out.println(Colors.RED + "seleccion invalida, por favor ingresa un numero entre 1 y 4"
                                + Colors.RESET);
                        System.out.println("\n--------------------");
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
                System.out.println("\n--------------------");
                System.out.println(Colors.RED + "seleccion invalida, por favor ingresa un numero entre 1 y 5");
                System.out.println("\n--------------------");
                menu(scanner);
        }
    }

    private final BookController bookController;
    // private final AuthorRepositoryImpl authorRepositoryImpl;

    public BookView(BookController bookController) {
        this.bookController = bookController;
        // this.authorRepositoryImpl = authorRepositoryImpl;

    }

    public void createBook(Scanner scanner) {
        System.out.println("** Nuevo libro **");
        System.out.println("\n--------------------");
        System.out.println("\nIngrese título del libro: ");
        String title = scanner.nextLine();
        System.out.println("Ingrese Nombre y apellido del autor: ");
        String authorName = scanner.nextLine();
        Author author = new Author(authorName);
        author.setName(authorName);

        bookController.createAuthor(author);
        System.out.println("Ingrese descripción del libro (máx. 200 caractéres): ");
        String description = scanner.nextLine();
        System.out.println("Ingrese el código ISBN (xxx-x-xxxxx-xxx-x): ");
        String code = scanner.nextLine();

        // authorRepositoryImpl.createAuthor(author);

        System.out.println("Ingrese género del libro: ");
        String genreName = scanner.nextLine();
        Genre genre = bookController.getGenreByName(genreName);
        if (genre == null) {
            genre = new Genre(genreName);
            genre.setname(genreName);
            genre = bookController.createGenre(genre);
           
            System.out.println("\n--------------------");
            System.out.println(Colors.GREEN + "\nGénero creado con éxito!" + Colors.RESET);
        }
        // Book book = new Book(title, description, code);
        Book book = new Book(title, description, code);
        book.setGenre(genre);
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
        /*
         * Book book = bookController.readBookById(id);
         * 
         * if (book.getGenre() == null) {
         * System.out.println("\n--------------------");
         * System.out.println(Colors.RED + "No existe un libro con ID: " + id +
         * Colors.RESET);
         * System.out.println("\n--------------------");
         * menu(scanner);
         * }
         */

        menu(scanner);
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

        Book book = bookController.readBookById(id);
        book.setTitle(title);
        book.setCode(code);
        book.setDescription(description);

        bookController.updateBook(book);
        System.out.println("\n--------------------");
        System.out.println(Colors.GREEN + "libro actualizado correctamente" + Colors.RESET);
        System.out.println("\n--------------------");
        menu(scanner);
    }

    public void deleteBookView(Scanner scanner) {
        System.out.print("Introduce el ID del libro a borrar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bookController.deleteBook(id);
        System.out.println("\n--------------------");
        System.out.println(Colors.GREEN + "Libro eliminado correctamente." + Colors.RESET);
        System.out.println("\n--------------------");
        menu(scanner);
    }

}
