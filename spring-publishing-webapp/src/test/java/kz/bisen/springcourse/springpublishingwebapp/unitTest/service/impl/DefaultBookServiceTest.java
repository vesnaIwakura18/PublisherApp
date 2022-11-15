package kz.bisen.springcourse.springpublishingwebapp.unitTest.service.impl;

import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DefaultBookServiceTest {
    private static final Integer ID = 1;

    @Mock
    private BookRepository repository;

    @InjectMocks
    private DefaultBookService service;

    @Test
    void findById_shouldCallRepository() {
        final Book book = mock(Book.class);
        when(repository.findById(ID)).thenReturn(Optional.of(book));

        Book actualBook = service.findById(ID);

        assertEquals(book, actualBook);
        assertNotNull(actualBook);
        verify(repository).findById(ID);
    }

    @Test
    void findAll_shouldCallRepository() {
        final List<Book> books  = List.of(mock(Book.class));
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Order.asc("title")));
        when(repository.findAll(pageRequest).getContent()).thenReturn(books);

        List<Book> actualBooks = service.findAllPaginated(0, 2, true);

        assertEquals(books, actualBooks);
        assertNotNull(actualBooks);
        verify(repository).findAll();
    }

    @Test
    void save_shouldCallRepository() {
        final Book book = mock(Book.class);

        service.save(book);

        verify(repository).save(book);
    }

    @Test
    void update_shouldCallRepository() {
        final Book book = mock(Book.class);

        service.update(ID, book);

        verify(repository).save(book);
    }

    @Test
    void deleteById_shouldCallRepository() {
        service.deleteById(ID);

        verify(repository).deleteById(ID);
    }
}
