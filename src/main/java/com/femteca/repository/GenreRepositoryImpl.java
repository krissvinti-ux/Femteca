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
        String sql = "SELECT id, name, FROM genre WHERE id = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);

            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    Genre genre = new Genre();
                    genre.setId(rs.getInt("id"));
                    genre.setname(rs.getString("name"));
                    return genre;
                }
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al leer el genero: " + e.getMessage());
        }
    }

    public Genre findByName(String name) {
        String sql = "SELECT id, name FROM genre WHERE name = ?";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, name);
            ResultSet result = st.executeQuery();

            if (result.next()) {
                Genre genre = new Genre();
                genre.setId(result.getInt("id"));
                genre.setname(result.getString("name"));
                return genre;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar género" + e.getMessage());
        }
    }

    @Override
    public Genre saveGenre(Genre genre){
        String sql = "INSERT INTO genre (name) VALUES (?)";

        try (Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(
                    sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

        st.setString(1, genre.getname());
        st.executeUpdate();


        ResultSet result= st.getGeneratedKeys();
        if (result.next()){
            genre.setId(result.getInt(1));
        }
        return genre;
    } catch (SQLException e) {
        throw new RuntimeException("Error al crear género " + e.getMessage());
    }
}

}
