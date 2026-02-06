package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Genre;

public class GenreRepositoryImpl implements GenreRepository {

    @Override
    public void updateGenre(Genre genre) {

        String sql = "UPDATE genres" + " SET genre = ? " + " WHERE genre_id = ? ";
        try (Connection connection = DBManager.getConnection(); PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, genre.getGenre());
            st.setInt(2, genre.getId());
            st.executeUpdate();
            System.out.println("El genero ha sido actualizado correctamente ");
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el genero" + e.getMessage());
        }
    }
}
