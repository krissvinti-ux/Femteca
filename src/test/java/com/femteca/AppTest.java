package com.femteca;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.femteca.model.Book;
import com.femteca.repository.BookRepositoryImpl;

@ExtendWith(MockitoExtension.class)
class BookRepositoryImplTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private BookRepositoryImpl bookRepository;

@Test
void shouldCallAuthorRepositoryWhenLoadingBook() {

    int authorId = 2;

    Author author = new Author();
    author.setId(authorId);
    author.setName("Isabel Allende");

    when(authorRepository.findById(authorId)).thenReturn(author);

    // simulate BookRepository logic
    Book book = new Book(
        "La casa de los espíritus",
        "Realismo mágico",
        "ISBN-456",
        author
    );

    // verify
    verify(authorRepository, times(1)).findById(authorId);
    assertEquals("Isabel Allende", book.getAuthor().getName());
}
}