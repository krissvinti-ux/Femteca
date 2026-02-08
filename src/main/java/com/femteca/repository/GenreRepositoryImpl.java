package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Genre;

public class GenreRepositoryImpl implements GenreRepository {

    @Override
    public Genre readGenreById(int id) {
        String sql = "SELECT id, name, FROM books WHERE id = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Genre genre = new Genre();
                    genre.setId(rs.getInt("id"));
                    
                    return genre;
                }
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al leer el genero: " + e.getMessage());
        }
    }
}
