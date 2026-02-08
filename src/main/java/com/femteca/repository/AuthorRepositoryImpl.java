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

    String sql = "SELECT id, author FROM authors WHERE id = ?";

    try (
        Connection connection = DBManager.getConnection();
        PreparedStatement st = connection.prepareStatement(sql)
    ) {

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
            "No se ha podido leer el autor con id " + id + ": " + e.getMessage()
        );
    }

    return null;
}
    }

