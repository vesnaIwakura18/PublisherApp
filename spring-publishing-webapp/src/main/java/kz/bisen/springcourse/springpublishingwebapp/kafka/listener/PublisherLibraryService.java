package kz.bisen.springcourse.springpublishingwebapp.kafka.listener;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultBookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.kafka.producer.BookQuantityProducer;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherLibraryService {
    private final BookRepository repository;

    private final DefaultBookDtoBuilder dtoBuilder;

    private final KafkaTemplate<String, Optional<BookDto>> kafkaTemplate;

    @Autowired
    public PublisherLibraryService(BookRepository repository,
                                   DefaultBookDtoBuilder dtoBuilder,
                                   KafkaTemplate<String, Optional<BookDto>> kafkaTemplate) {
        this.dtoBuilder = dtoBuilder;
        this.kafkaTemplate = kafkaTemplate;
        this.repository = repository;
    }

    @KafkaListener(topics = "producer.topic", groupId = "publisher-B")
    public void handle(BookDto bookDto) {
        final Book book = dtoBuilder.fromBookDto(bookDto);
        repository.save(book);
    }

    @KafkaListener(topics = "producer.topic", groupId = "publisher-B")
    public void handle(List<BookDto> bookDtos) {
        final List<Book> books = bookDtos
                                            .stream()
                                            .map(dtoBuilder::fromBookDto)
                                            .toList();
        repository.saveAll(books);
    }

    @KafkaListener(topics = "producer.topic", groupId = "publisher-B")
    public void handle(String isbn) {
        Optional<BookDto> bookDto = Optional.of(dtoBuilder.fromBook(repository.findByIsbn(isbn).get()));
        kafkaTemplate.send("library-A.topic", bookDto);
    }
}
