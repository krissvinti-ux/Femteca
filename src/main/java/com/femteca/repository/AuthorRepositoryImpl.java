package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Author;

public class AuthorRepositoryImpl implements AuthorRepository {

    @Override
    public void createAuthor(Author author) {

        String sql = "INSERT INTO author (name) VALUES (?)";

        try (Connection connection = DBManager.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {

            st.setString(1, author.getName());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al crear autor: " + e.getMessage());
        }
    }
}
