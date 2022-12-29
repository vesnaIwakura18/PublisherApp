//package kz.bisen.springcourse.springpublishingwebapp.unitTest.controller.impl;
//
//import kz.bisen.springcourse.springpublishingwebapp.controller.PublisherController;
//import kz.bisen.springcourse.springpublishingwebapp.dto.PublisherDto;
//import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultPublisherDtoBuilder;
//import kz.bisen.springcourse.springpublishingwebapp.entity.Publisher;
//import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultPublisherService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.validation.BindingResult;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.verify;
//
//@ExtendWith(MockitoExtension.class)
//public class PublisherControllerTest {
//    private static final Integer ID = 1;
//
//    @Mock
//    private DefaultPublisherService service;
//
//    @Mock
//    private DefaultPublisherDtoBuilder dtoBuilder;
//
//    @Mock
//    private BindingResult bindingResult;
//
//    @InjectMocks
//    private PublisherController controller;
//
//    @Test
//    void getAllPaginated() {
//        final Publisher publisher = mock(Publisher.class);
//        when(service.findAllPaginated(0, 1, false)).thenReturn(List.of(publisher));
//        final PublisherDto publisherDto = mock(PublisherDto.class);
//        when(dtoBuilder.fromPublisher(publisher)).thenReturn(publisherDto);
//
//        final PublisherDto actualPublisherDto = controller.getAllPaginated(0, 1, false).stream().findAny().orElse(null);
//
//        assertEquals(publisherDto, actualPublisherDto);
//        assertNotNull(actualPublisherDto);
//        verify(service).findAllPaginated(0, 1, false);
//        verify(dtoBuilder).fromPublisher(publisher);
//    }
//
//    @Test
//    void getById() {
//        final Publisher publisher = mock(Publisher.class);
//        when(service.findById(ID)).thenReturn(publisher);
//        final PublisherDto publisherDto = mock(PublisherDto.class);
//        when(dtoBuilder.fromPublisher(publisher)).thenReturn(publisherDto);
//
//        final PublisherDto actualPublisherDto = controller.getById(ID);
//
//        assertEquals(publisherDto, actualPublisherDto);
//        assertNotNull(actualPublisherDto);
//        verify(service).findById(ID);
//        verify(dtoBuilder).fromPublisher(publisher);
//    }
//
//    @Test
//    void create() {
//        final Publisher publisher = mock(Publisher.class);
//        final PublisherDto publisherDto = mock(PublisherDto.class);
//        when(dtoBuilder.fromPublisherDto(publisherDto)).thenReturn(publisher);
//
//        controller.create(publisherDto, bindingResult);
//
//        verify(dtoBuilder).fromPublisherDto(publisherDto);
//        verify(service).save(publisher);
//    }
//
//    @Test
//    void update() {
//        final Publisher publisherToUpdate = mock(Publisher.class);
//        final PublisherDto publisherDtoToUpdate = mock(PublisherDto.class);
//        when(dtoBuilder.fromPublisherDto(publisherDtoToUpdate)).thenReturn(publisherToUpdate);
//
//        controller.update(ID, publisherDtoToUpdate, bindingResult);
//
//        verify(dtoBuilder).fromPublisherDto(publisherDtoToUpdate);
//        verify(service).update(ID, publisherToUpdate);
//    }
//
//    @Test
//    void deleteById() {
//        controller.deleteById(ID);
//
//        verify(service).deleteById(ID);
//    }
//}
