//package kz.bisen.springcourse.springpublishingwebapp.unitTest.service.impl;
//
//import kz.bisen.springcourse.springpublishingwebapp.entity.Author;
//import kz.bisen.springcourse.springpublishingwebapp.repository.AuthorRepository;
//import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultAuthorService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class DefaultAuthorServiceTest {
//    private static final Integer ID = 1;
//
//    @Mock
//    private AuthorRepository repository;
//
//    @InjectMocks
//    private DefaultAuthorService service;
//
//    @Test
//    void findById_shouldCallRepository() {
//        final Author author = mock(Author.class);
//        when(repository.findById(ID)).thenReturn(Optional.of(author));
//
//        Author actualAuthor = service.findById(ID);
//
//        assertEquals(author, actualAuthor);
//        assertNotNull(actualAuthor);
//        verify(repository).findById(ID);
//    }
//
//    @Test
//    void findAll_shouldCallRepository() {
//        final Author author = mock(Author.class);
//        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Order.asc("firstName")));
//        when(repository.findAll(pageRequest).getContent()).thenReturn(List.of(author));
//
//        final Author actualAuthor = service.findAllPaginated(0, 2, true).stream().findAny().orElse(null);
//
//        assertEquals(author, actualAuthor);
//        assertNotNull(actualAuthor);
//        verify(repository).findAll();
//    }
//
//    @Test
//    void save_shouldCallRepository() {
//        final Author author = mock(Author.class);
//
//        service.save(author);
//
//        verify(repository).save(author);
//    }
//
//    @Test
//    void update_shouldCallRepository() {
//        final Author author = mock(Author.class);
//
//        service.update(ID, author);
//
//        verify(repository).save(author);
//    }
//
//    @Test
//    void deleteById_shouldCallRepository() {
//        service.deleteById(ID);
//
//        verify(repository).deleteById(ID);
//    }
//}
