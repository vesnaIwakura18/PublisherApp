//package kz.bisen.springcourse.springpublishingwebapp.unitTest.service.impl;
//
//import kz.bisen.springcourse.springpublishingwebapp.entity.Publisher;
//import kz.bisen.springcourse.springpublishingwebapp.repository.PublisherRepository;
//import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultPublisherService;
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
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class DefaultPublisherServiceTest {
//    private static final Integer ID = 1;
//
//    @Mock
//    private PublisherRepository repository;
//
//    @InjectMocks
//    private DefaultPublisherService service;
//
//    @Test
//    void findById_shouldCallRepository() {
//        final Publisher publisher = mock(Publisher.class);
//        when(repository.findById(ID)).thenReturn(Optional.of(publisher));
//
//        Publisher actualPublisher = service.findById(ID);
//
//        assertEquals(publisher, actualPublisher);
//        assertNotNull(actualPublisher);
//        verify(repository).findById(ID);
//    }
//
//    @Test
//    void findAll_shouldCallRepository() {
//        final List<Publisher> publishers = List.of(mock(Publisher.class));
//        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Order.asc("title")));
//        when(repository.findAll(pageRequest).getContent()).thenReturn(publishers);
//
//        List<Publisher> actualPublishers = service.findAllPaginated(0, 2, true);
//
//        assertEquals(publishers, actualPublishers);
//        assertNotNull(actualPublishers);
//        verify(repository).findAll();
//    }
//
//    @Test
//    void save_shouldCallRepository() {
//        final Publisher publisher = mock(Publisher.class);
//
//        service.save(publisher);
//
//        verify(repository).save(publisher);
//    }
//
//    @Test
//    void update_shouldCallRepository() {
//        final Publisher publisher = mock(Publisher.class);
//
//        service.update(ID, publisher);
//
//        verify(repository).save(publisher);
//    }
//
//    @Test
//    void deleteById_shouldCallRepository() {
//        service.deleteById(ID);
//
//        verify(repository).deleteById(ID);
//    }
//}
