package com.femteca.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.femteca.config.DBManager;
import com.femteca.model.Author;

public class AuthorRepositoryImpl implements AuthorRepository {

    
    @Override
    public String readAuthors() {

        String sql = "SELECT id, author FROM authors";

        try (
            Connection connection = DBManager.getConnection(); PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
        ) {
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getInt("id"));
                author.setName(rs.getString("author"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("no se ha podido leer la lista de autores"+ e.getMessage());
        }

        return null;
    }

}

