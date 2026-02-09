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

public class BookRepositoryImpl implements BookRepository {

    private final AuthorRepository authorRepository;

    public BookRepositoryImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(Book book) {
        
        String sql = "INSERT INTO books (title, description, code) VALUES (?, ?, ?)";

        try (Connection connection = DBManager.getConnection(); PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, book.getTitle());
            //st.setString(2, book.getAuthor());
            st.setString(2, book.getDescription());
            st.setString(3, book.getCode());
            //st.setString(5, book.getGenre());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear Libro" + e.getMessage());
        }

    }


    @Override
    public Book readBookById(int id) {
        String sql = "SELECT id, title, description, code, author_id FROM books WHEREid = ?"; 

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    int authorId = rs.getInt("author_id");
                    Author author = authorRepository.readAuthor(authorId);
                    Book book = new Book( 
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("code"),
                    author);
                    
                    return book;
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al leer libro: " + e.getMessage());
        }
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
            a.author AS author_name
        FROM books b
        JOIN authors a ON b.author_id = a.id
        WHERE a.author ILIKE ?
    """;

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, "%" +  authorName + "%");
            ResultSet rs = st.executeQuery();

                while (rs.next()) {

            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            author.setName(rs.getString("author_name"));

            Book book = new Book(
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("code"),
                author
            );
            book.setId(rs.getInt("book_id"));

            books.add(book);
        }

    } catch (SQLException e) {
        throw new RuntimeException(
            "No se ha podido buscar libros por autor: " + e.getMessage()
        );
    }

    return books;
}

    @Override
    public void updateBook(Book book) {

    String sql =
    "UPDATE books " +
    "SET title = ?, description = ?, code = ? " +
    "WHERE id = ?";

        try (Connection connection = DBManager.getConnection(); PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, book.getTitle());
            st.setString(2, book.getDescription());
            st.setString(3, book.getCode());
            st.setInt(4, book.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar libro" + e.getMessage());
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
            throw new RuntimeException("Error al borrar Libro: " + e.getMessage());
        }
    }
}
