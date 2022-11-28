package kz.bisen.springcourse.springpublishingwebapp.kafka.scheduler;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultBookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.kafka.producer.NewBookProducer;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Component
public class BookScheduler {
    private final BookRepository repository;

    private final DefaultBookDtoBuilder dtoBuilder;

    private final NewBookProducer producer;

    @Autowired
    private BookScheduler(BookRepository repository, DefaultBookDtoBuilder dtoBuilder, NewBookProducer producer) {
        this.repository = repository;
        this.dtoBuilder = dtoBuilder;
        this.producer = producer;
    }

    @Scheduled(fixedRateString = "PT01D", initialDelay = 1000)
    private void scheduleIncrease() {
        LocalDateTime current = LocalDateTime.now();

        List<Book> books = repository.findAll();
        repository.saveAll(
                books
                        .stream()
                        .peek(b -> b.setAmount(b.getAmount() + new Random().nextInt(200)))
                        .toList());

        log.info("Done, time: " + current);
    }

    @Scheduled(fixedRateString = "PT02H", initialDelay = 1000)
    private void scheduleReduce() {
        LocalDateTime current = LocalDateTime.now();

        List<Book> books = repository.findAll();
        repository.saveAll(
                books
                        .stream()
                        .peek(b -> b.setAmount(b.getAmount() - new Random().nextInt(5)))
                        .toList());

        log.info("Done, time: " + current);
    }

    @Scheduled(fixedRateString = "PT05H", initialDelay = 1000)
    private void checkNewBooks() throws Exception {
        final LocalDateTime dateTime = repository.findLastScanDateTime().orElseThrow(Exception::new);
        final List<Book> books = repository.findByScannedDateTimeLessThan(dateTime);
        final List<BookDto> bookDtos = books.stream().map(dtoBuilder::fromBook).toList();
        producer.send(bookDtos);

        repository.findAll()
                .forEach(b -> {
                    b.setScannedDateTime(LocalDateTime.now());
                    repository.save(b);
                });
    }
}
