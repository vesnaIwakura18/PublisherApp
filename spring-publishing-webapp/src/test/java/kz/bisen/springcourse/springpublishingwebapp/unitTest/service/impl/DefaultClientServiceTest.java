package kz.bisen.springcourse.springpublishingwebapp.unitTest.service.impl;

import kz.bisen.springcourse.springpublishingwebapp.entity.Client;
import kz.bisen.springcourse.springpublishingwebapp.repository.ClientRepository;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultClientService;
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
public class DefaultClientServiceTest {
    private static final Integer ID = 1;

    @Mock
    private ClientRepository repository;

    @InjectMocks
    private DefaultClientService service;

    @Test
    void findById_shouldCallRepository() {
        final Client client = mock(Client.class);
        when(repository.findById(ID)).thenReturn(Optional.of(client));

        Client actualClient = service.findById(ID);

        assertEquals(client, actualClient);
        assertNotNull(actualClient);
        verify(repository).findById(ID);
    }

    @Test
    void findAll_shouldCallRepository() {
        final List<Client> clients  = List.of(mock(Client.class));
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by(Sort.Order.asc("title")));
        when(repository.findAll(pageRequest).getContent()).thenReturn(clients);

        List<Client> actualClients = service.findAllPaginated(0, 2, true);

        assertEquals(clients, actualClients);
        assertNotNull(actualClients);
        verify(repository).findAll();
    }

    @Test
    void save_shouldCallRepository() {
        final Client client = mock(Client.class);

        service.save(client);

        verify(repository).save(client);
    }

    @Test
    void update_shouldCallRepository() {
        final Client client = mock(Client.class);

        service.update(ID, client);

        verify(repository).save(client);
    }

    @Test
    void deleteById_shouldCallRepository() {
        service.deleteById(ID);

        verify(repository).deleteById(ID);
    }
}
