package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.femteca.config.DBManager;

import com.femteca.model.Book;
import com.femteca.model.Colors;

public class BookRepositoryImpl implements BookRepository {

    @Override
    public void createBook(Book book) {
        
        String sql = "INSERT INTO books (title, description, code, author_id, genre_id) VALUES (?, ?, ?, ?,?)";

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
        String sql = "SELECT id, title, description, code FROM books WHERE id = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setTitle(rs.getString("title"));
                    book.setDescription(rs.getString("description"));
                    book.setCode(rs.getString("code"));
                    return book;
                }
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(Colors.RED + "Error al leer libro: " + e.getMessage() + Colors.RESET);
        }
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
