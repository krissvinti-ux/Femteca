package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Genre;

public class GenreRepositoryImpl implements GenreRepository {

    @Override
    public void updateGenre(Genre genre) {

        String sql = "UPDATE Genre SET Genre = '?' WHERE Genre = '?'";
        try (Connection connection = DBManager.getConnection(); PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, genre.getGenre());
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar libro" + e.getMessage());
        }
    }
}
