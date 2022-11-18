package kz.bisen.springcourse.springpublishingwebapp.kafka.scheduler;

import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Slf4j
@Component
public class BookAmountChangeScheduler {
    private final BookRepository repository;

    @Autowired
    public BookAmountChangeScheduler(BookRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRateString = "PT01D", initialDelay = 1000)
    public void scheduleIncrease() {
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
    public void scheduleReduce() {
        LocalDateTime current = LocalDateTime.now();

        List<Book> books = repository.findAll();
        repository.saveAll(
                books
                        .stream()
                        .peek(b -> b.setAmount(b.getAmount() - new Random().nextInt(5)))
                        .toList());

        log.info("Done, time: " + current);
    }

//    @Scheduled(fixedRateString = "PTO2H", initialDelay = 1000)
//    public void scheduleState() {
//        List<Book> previous = repository.findAll();
//    }
}
