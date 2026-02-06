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
                PreparedStatement pedido = connection.prepareStatement(sql)) {

            pedido.setInt(1, id);

            try (ResultSet respuesta = pedido.executeQuery()) {
                if (respuesta.next()) {
                    Book book = new Book();
                    book.setId(respuesta.getInt("id"));
                    book.setTitle(respuesta.getString("title"));
                    book.setDescription(respuesta.getString("description"));
                    book.setCode(respuesta.getString("code"));
                    return book;
                }
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al leer libro: " + e.getMessage());
        }
    }
}
