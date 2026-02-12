package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.femteca.config.DBManager;
import com.femteca.model.Author;
import com.femteca.model.Book;
import com.femteca.model.Genre;
import com.femteca.model.Colors;

public class BookRepositoryImpl implements BookRepository {
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    public BookRepositoryImpl(GenreRepository genreRepository, AuthorRepository authorRepository) {
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
        ;
    }

    @Override
    public void createBook(Book book) {

        String sql = "INSERT INTO books (title, description, code, author_id, genre_id) VALUES (?, ?, ?, ?, ?)";

        if (book.getGenre() == null) {
            throw new RuntimeException("El libro debe tener un género asignado");
        }

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, book.getTitle());
            st.setString(2, book.getDescription());
            st.setString(3, book.getCode());
            st.setInt(4, book.getAuthor().getId());
            st.setInt(5, book.getGenre().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(Colors.RED + "Error al crear Libro" + e.getMessage() + Colors.RESET);
        }

    }

    @Override
    public Book readBookById(int id) {
        String sql = "SELECT id, title, description, code, genre_id, author_id FROM books WHERE id = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int genre_id = rs.getInt("genre_id");
                    Genre genre = genreRepository.readGenreById(genre_id);

                    int authorId = rs.getInt("author_id");
                    Author author = authorRepository.readAuthor(authorId);

                    Book book = new Book();
                        book.setId(rs.getInt("id"));
                        book.setTitle(rs.getString("title"));
                        book.setDescription(rs.getString("description"));
                        book.setCode(rs.getString("code"));
                        book.setGenre(null);
                        book.setAuthor(null);

                    return book;
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(Colors.RED + "Error al leer libro: " + e.getMessage() + Colors.RESET);
        }
    }

    @Override
    public List<Book> readBookByGenre(String genreName) {

        List<Book> books = new ArrayList<>();

        String sql = """
                SELECT b.id AS book_id,
                                b.title,
                                b.description,
                                b.code,
                                g.id AS genre_id,
                                g.name AS genre_name,
                                a.id AS author_id,
                                a.name AS author_name
                            FROM books b
                            JOIN genres g ON b.genre_id = g.id
                            JOIN authors a ON b.author_id = a.id
                            WHERE g.name ILIKE ?
                        """;

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, "%" + genreName + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Genre genre = new Genre();
                genre.setId(rs.getInt("genre_id"));
                genre.setname(rs.getString("genre_name"));

                Author author = new Author();
                author.setId(rs.getInt("author_id"));
                author.setName(rs.getString("author_name"));

                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("code"),
                        author, genre);
                book.setId(rs.getInt("book_id"));

                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se ha podido buscar libros por genero: " + e.getMessage());
        }

        return books;
    }

    @Override
    public List<Book> readBookByAuthor(String authorName) {

        List<Book> books = new ArrayList<>();

        String sql = """
                    SELECT b.id AS book_id,
                        b.title,
                        b.description,
                        b.code,
                        a.id AS author_id,
                        a.name AS author_name,
                        g.id AS genre_id,
                        g.name AS genre_name
                    FROM books b
                    JOIN authors a ON b.author_id = a.id
                    JOIN genres g ON b.genre_id = g.id
                    WHERE a.name ILIKE ?
                """;

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, "%" + authorName + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Author author = new Author();
                author.setId(rs.getInt("author_id"));
                author.setName(rs.getString("author_name"));

                Genre genre = new Genre();
                genre.setId(rs.getInt("genre_id"));
                genre.setname(rs.getString("genre_name"));

                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("code"),
                        author, genre);
                book.setId(rs.getInt("book_id"));

                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se ha podido buscar libros por autor: " + e.getMessage());
        }

        return books;
    }

    @Override
    public void updateBook(Book book) {

        String sql = "UPDATE books " +
                "SET title = ?, description = ?, code = ? " +
                "WHERE id = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, book.getTitle());
            st.setString(2, book.getDescription());
            st.setString(3, book.getCode());
            st.setInt(4, book.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(Colors.RED + "Error al actualizar libro" + e.getMessage() + Colors.RESET);
        }

    }

    @Override
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);
            st.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(Colors.RED + "Error al borrar Libro: " + e.getMessage() + Colors.RESET);
        }
    }

    @Override
    public List<Book> findAll() {

        List<Book> books = new ArrayList<>();

        String sql = """
                    SELECT b.id AS book_id,
                        b.title,
                        b.description,
                        b.code,
                        a.id AS author_id,
                        a.name AS author_name
                    FROM books b
                    LEFT JOIN authors a ON b.author_id = a.id
                    ORDER BY b.id
                """;

        try (
                Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql);
                ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                Author author = null;
                // Genre genre = null;

                if (rs.getObject("author_id") != null) {
                    author = new Author();
                    author.setId(rs.getInt("author_id"));
                    author.setName(rs.getString("author_name"));
                }
                // if (rs.getObject("genre_id") != null) {
                //     genre = new Genre();
                //     genre.setId(rs.getInt("genre_id"));
                //     genre.setname(rs.getString("genre_name"));
                // }

                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("code"),
                        author);
                book.setId(rs.getInt("book_id"));

                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se ha podido leer la lista de libros: " + e.getMessage());
        }

        return books;
    }

        @Override
    public Book readBookByTitle(String title) {
        String sql = "SELECT id, title, description, code, genre_id, author_id FROM books WHERE title = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, title);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int genre_id = rs.getInt("genre_id");
                    Genre genre = genreRepository.readGenreById(genre_id);

                    int authorId = rs.getInt("author_id");
                    Author author = authorRepository.readAuthor(authorId);

                    Book book = new Book();
                        book.setId(rs.getInt("id"));
                        book.setTitle(rs.getString("title"));
                        book.setDescription(rs.getString("description"));
                        book.setCode(rs.getString("code"));
                        book.setGenre(null);
                        book.setAuthor(null);

                    return book;
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(Colors.RED + "Error al leer libro: " + e.getMessage() + Colors.RESET);
        }
    }
}
