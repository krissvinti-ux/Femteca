package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.femteca.config.DBManager;
import com.femteca.model.Book;

public class BookRepositoryImpl implements BookRepository {

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
            throw new RuntimeException("Error al leer libro: " + e.getMessage());
        }
    }
}
