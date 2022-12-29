//package kz.bisen.springcourse.springpublishingwebapp.unitTest.controller.impl;
//
//import kz.bisen.springcourse.springpublishingwebapp.controller.ClientController;
//import kz.bisen.springcourse.springpublishingwebapp.dto.ClientDto;
//import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultClientDtoBuilder;
//import kz.bisen.springcourse.springpublishingwebapp.entity.Client;
//import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultClientService;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.validation.BindingResult;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.verify;
//
//public class ClientControllerTest {
//    private static final Integer ID = 1;
//
//    @Mock
//    private DefaultClientService service;
//
//    @Mock
//    private DefaultClientDtoBuilder dtoBuilder;
//
//    @Mock
//    private BindingResult bindingResult;
//
//    @InjectMocks
//    private ClientController controller;
//
//    @Test
//    void getAllPaginated() {
//        final Client client = mock(Client.class);
//        when(service.findAllPaginated(0, 1, false)).thenReturn(List.of(client));
//        final ClientDto clientDto = mock(ClientDto.class);
//        when(dtoBuilder.fromClient(client)).thenReturn(clientDto);
//
//        final ClientDto actualClientDto = controller.getAllPaginated(0, 1, false).stream().findAny().orElse(null);
//
//        assertEquals(clientDto, actualClientDto);
//        assertNotNull(actualClientDto);
//        verify(service).findAllPaginated(0, 1, false);
//        verify(dtoBuilder).fromClient(client);
//    }
//
//    @Test
//    void getById() {
//        final Client client = mock(Client.class);
//        when(service.findById(ID)).thenReturn(client);
//        final ClientDto clientDto = mock(ClientDto.class);
//        when(dtoBuilder.fromClient(client)).thenReturn(clientDto);
//
//        final ClientDto actualClientDto = controller.getById(ID);
//
//        assertEquals(clientDto, actualClientDto);
//        assertNotNull(actualClientDto);
//        verify(service).findById(ID);
//        verify(dtoBuilder).fromClient(client);
//    }
//
//    @Test
//    void create() {
//        final Client client = mock(Client.class);
//        final ClientDto clientDto = mock(ClientDto.class);
//        when(dtoBuilder.fromClientDto(clientDto)).thenReturn(client);
//
//        controller.create(clientDto, bindingResult);
//
//        verify(dtoBuilder).fromClientDto(clientDto);
//        verify(service).save(client);
//    }
//
//    @Test
//    void update() {
//        final Client clientToUpdate = mock(Client.class);
//        final ClientDto clientDtoToUpdate = mock(ClientDto.class);
//        when(dtoBuilder.fromClientDto(clientDtoToUpdate)).thenReturn(clientToUpdate);
//
//        controller.update(ID, clientDtoToUpdate, bindingResult);
//
//        verify(dtoBuilder).fromClientDto(clientDtoToUpdate);
//        verify(service).update(ID, clientToUpdate);
//    }
//
//    @Test
//    void deleteById() {
//        controller.deleteById(ID);
//
//        verify(service).deleteById(ID);
//    }
//}
