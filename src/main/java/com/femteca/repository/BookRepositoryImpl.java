package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import com.femteca.config.DBManager;
import com.femteca.model.Book;
import com.femteca.model.Genre;
import com.femteca.model.Colors;

public class BookRepositoryImpl implements BookRepository{
    private final GenreRepository genreRepository;

    public BookRepositoryImpl (GenreRepository genreRepository){
        this.genreRepository= genreRepository;
    }

    @Override
    public void createBook(Book book) {

        if (book.getGenre() == null) {
            throw new RuntimeException("El libro debe tener un género asignado");
        }

        String sql = "INSERT INTO books (title, description, code, genre_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, book.getTitle());
            // st.setString(2, book.getAuthor());
            st.setString(2, book.getDescription());
            st.setString(3, book.getCode());
            st.setInt(4, book.getGenre().getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(Colors.RED + "Error al crear Libro" + e.getMessage() + Colors.RESET);
        }

    }
    

    @Override
    public Book readBookById(int id) {
        String sql = "SELECT id, title, description, code, genre_id FROM books WHERE id = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int genre_id= rs.getInt ("genre_id");
                    Genre genre =genreRepository.readGenreById(genre_id);
                    Book book = new Book( 
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("code"),
                    genre);
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
           a.id AS genre_id,
           a.genre AS genre_name
    FROM books b
    JOIN genre a ON b.genre_id = a.id
    WHERE a.genre ILIKE ?
""";



        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, "%" +  genreName + "%");
            ResultSet rs = st.executeQuery();

                while (rs.next()) {

            Genre genre = new Genre();
            genre.setId(rs.getInt("genre_id"));
            genre.setname(rs.getString("genre_name"));

            Book book = new Book(
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("code"),
                genre
            );
            book.setId(rs.getInt("book_id"));

            books.add(book);
        }

    } catch (SQLException e) {
        throw new RuntimeException(
            "No se ha podido buscar libros por genero: " + e.getMessage()
        );
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

       }

   
