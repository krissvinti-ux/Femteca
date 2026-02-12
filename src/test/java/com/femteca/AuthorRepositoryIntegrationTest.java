package com.femteca;

import com.femteca.repository.AuthorRepositoryImpl;
import com.femteca.model.Author;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthorRepositoryImplTest {

    @Test
    void testCreateAuthorIntegration() {
        AuthorRepositoryImpl repo = new AuthorRepositoryImpl();

        Author author = new Author("Borges");
        repo.createAuthor(author);

        assertTrue(author.getId() > 0);

        Author found = repo.readAuthor(author.getId());
        assertEquals("Borges", found.getName());
    }
}
