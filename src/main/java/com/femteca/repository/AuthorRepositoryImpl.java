package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Author;

public class AuthorRepositoryImpl implements AuthorRepository {

    @Override
    public Author readAuthor(int id) {

        String sql = "SELECT id, name FROM authors WHERE id = ?";

        try (
                Connection connection = DBManager.getConnection();
                PreparedStatement st = connection.prepareStatement(sql)) {

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("author"));
                return author;
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "No se ha podido leer el autor con id " + id + ": " + e.getMessage());
        }

        return null;
    }

    @Override
        public Author createAuthor(Author author) {
String sql = "INSERT INTO authors (name) VALUES (?)";

try (Connection connection = DBManager.getConnection();
    PreparedStatement st = connection.prepareStatement(
        sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

    st.setString(1, author.getName());
    st.executeUpdate();

    ResultSet result = st.getGeneratedKeys();
    if (result.next()) {
    author.setId(result.getInt(1));
    }

    return author;

    } catch (SQLException e) {
    throw new RuntimeException("Error al crear autor: " + e.getMessage());
    }
}

@Override
        public Author findByNameAuthor(String name) {
        String sql = "SELECT id, name FROM authors WHERE name = ?";

    try (Connection connection = DBManager.getConnection();
    PreparedStatement st = connection.prepareStatement(sql)) {

    st.setString(1, name);
    ResultSet result = st.executeQuery();

    if (result.next()) {
    Author author = new Author();
    author.setId(result.getInt("id"));
    author.setName(result.getString("name"));
    return author;
    }

    return null;    

        } catch (SQLException e) {
    throw new RuntimeException("Error al buscar autor: " + e.getMessage());
    }

        }
}