package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Book;

public class BookRepositoryImpl implements BookRepository{

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
