package kz.bisen.springcourse.springpublishingwebapp.unitTest.controller.impl;

import kz.bisen.springcourse.springpublishingwebapp.controller.BookController;
import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultBookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultBookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    private static final Integer ID = 1;

    @Mock
    private DefaultBookService service;

    @Mock
    private DefaultBookDtoBuilder dtoBuilder;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private BookController controller;

    @Test
    void getAllPaginated() {
        final Book book = mock(Book.class);
        when(service.findAllPaginated(0, 1, false)).thenReturn(List.of(book));
        final BookDto bookDto = mock(BookDto.class);
        when(dtoBuilder.fromBook(book)).thenReturn(bookDto);

        final BookDto actualBookDto = controller.getAllPaginated(0, 1, false).stream().findAny().orElse(null);

        assertEquals(bookDto, actualBookDto);
        assertNotNull(actualBookDto);
        verify(service).findAllPaginated(0, 1, false);
        verify(dtoBuilder).fromBook(book);
    }

    @Test
    void getById() {
        final Book book = mock(Book.class);
        when(service.findById(ID)).thenReturn(book);
        final BookDto bookDto = mock(BookDto.class);
        when(dtoBuilder.fromBook(book)).thenReturn(bookDto);

        final BookDto actualBookDto = controller.getById(ID);

        assertEquals(bookDto, actualBookDto);
        assertNotNull(actualBookDto);
        verify(service).findById(ID);
        verify(dtoBuilder).fromBook(book);
    }

    @Test
    void create() {
        final Book book = mock(Book.class);
        final BookDto bookDto = mock(BookDto.class);
        when(dtoBuilder.fromBookDto(bookDto)).thenReturn(book);

        controller.create(bookDto, bindingResult);

        verify(dtoBuilder).fromBookDto(bookDto);
        verify(service).save(book);
    }

    @Test
    void update() {
        final Book bookToUpdate = mock(Book.class);
        final BookDto bookDtoToUpdate = mock(BookDto.class);
        when(dtoBuilder.fromBookDto(bookDtoToUpdate)).thenReturn(bookToUpdate);

        controller.update(ID, bookDtoToUpdate, bindingResult);

        verify(dtoBuilder).fromBookDto(bookDtoToUpdate);
        verify(service).update(ID, bookToUpdate);
    }

    @Test
    void deleteById() {
        controller.deleteById(ID);

        verify(service).deleteById(ID);
    }
}
