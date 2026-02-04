package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Book;

public class BookRepositoryImpl implements BookRepositor {

    @Override
    public void createBook(Book book) {
        
        String sql = "INSERT INTO Femteca (title, author, description, code, genre) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBManager.getConnection(); PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, book.getTitle());
            st.setString(2, book.getAuthor());
            st.setString(3, book.getDescription());
            st.setString(4, book.getCode());
            st.setString(5, book.getGenre());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear Libro" + e.getMessage());
        }

    }

}
