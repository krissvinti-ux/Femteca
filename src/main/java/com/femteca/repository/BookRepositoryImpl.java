package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.femteca.config.DBManager;

public class BookRepositoryImpl implements BookRepository {

    @Override
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE book_id = ?";

        try (Connection connection = DBManager.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);
            st.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Error al borrar Libro: " + e.getMessage());
        }
    }
}
