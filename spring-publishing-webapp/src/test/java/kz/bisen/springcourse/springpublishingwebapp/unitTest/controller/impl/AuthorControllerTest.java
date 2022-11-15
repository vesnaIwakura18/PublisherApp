package kz.bisen.springcourse.springpublishingwebapp.unitTest.controller.impl;

import kz.bisen.springcourse.springpublishingwebapp.controller.AuthorController;
import kz.bisen.springcourse.springpublishingwebapp.dto.AuthorDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultAuthorDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Author;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultAuthorService;
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

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {
    private static final Integer ID = 1;

    @Mock
    private DefaultAuthorService service;

    @Mock
    private DefaultAuthorDtoBuilder dtoBuilder;

    @Mock
    private BindingResult bindingResult;

    @InjectMocks
    private AuthorController controller;

    @Test
    void getAllPaginated() {
        final Author author = mock(Author.class);
        when(service.findAllPaginated(0, 1, false)).thenReturn(List.of(author));
        final AuthorDto authorDto = mock(AuthorDto.class);
        when(dtoBuilder.fromAuthor(author)).thenReturn(authorDto);

        final AuthorDto actualAuthorDto = controller.getAllPaginated(0, 1, false).stream().findAny().orElse(null);

        assertEquals(authorDto, actualAuthorDto);
        assertNotNull(actualAuthorDto);
        verify(service).findAllPaginated(0, 1, false);
        verify(dtoBuilder).fromAuthor(author);
    }

    @Test
    void getById() {
        final Author author = mock(Author.class);
        when(service.findById(ID)).thenReturn(author);
        final AuthorDto authorDto = mock(AuthorDto.class);
        when(dtoBuilder.fromAuthor(author)).thenReturn(authorDto);

        final AuthorDto actualAuthorDto = controller.getById(ID);

        assertEquals(authorDto, actualAuthorDto);
        assertNotNull(actualAuthorDto);
        verify(service).findById(ID);
        verify(dtoBuilder).fromAuthor(author);
    }

    @Test
    void create() {
        final Author author = mock(Author.class);
        final AuthorDto authorDto = mock(AuthorDto.class);
        when(dtoBuilder.fromAuthorDto(authorDto)).thenReturn(author);

        controller.create(authorDto, bindingResult);

        verify(dtoBuilder).fromAuthorDto(authorDto);
        verify(service).save(author);
    }

    @Test
    void update() {
        final Author authorToUpdate = mock(Author.class);
        final AuthorDto authorDtoToUpdate = mock(AuthorDto.class);
        when(dtoBuilder.fromAuthorDto(authorDtoToUpdate)).thenReturn(authorToUpdate);

        controller.update(ID, authorDtoToUpdate, bindingResult);

        verify(dtoBuilder).fromAuthorDto(authorDtoToUpdate);
        verify(service).update(ID, authorToUpdate);
    }

    @Test
    void deleteById() {
        controller.deleteById(ID);

        verify(service).deleteById(ID);
    }
}
