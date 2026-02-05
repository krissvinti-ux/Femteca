package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Book;

public class BookRepositoryImpl implements BookRepository {

            @Override
    public void updateBook(Book book) {

    String sql =
    "UPDATE books " +
    "SET title = ?, description = ?, code = ? " +
    "WHERE book_id = ?";

        try (Connection connection = DBManager.getConnection(); PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, book.getTitle());
            st.setString(2, book.getDescription());
            st.setString(3, book.getCode());
            st.setInt(4, book.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar libro" + e.getMessage());
        }
    
}}

