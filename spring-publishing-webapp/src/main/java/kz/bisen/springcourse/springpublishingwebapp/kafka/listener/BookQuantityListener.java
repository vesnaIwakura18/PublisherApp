package kz.bisen.springcourse.springpublishingwebapp.kafka.listener;

import kz.bisen.springcourse.springpublishingwebapp.kafka.BookIsbnMessage;
import kz.bisen.springcourse.springpublishingwebapp.kafka.producer.BookQuantityProducer;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class BookQuantityListener {
    private final BookQuantityProducer messagingService;

    private final BookRepository repository;


    @Autowired
    public BookQuantityListener(BookQuantityProducer messagingService,
                                BookRepository repository) {
        this.messagingService = messagingService;
        this.repository = repository;
    }

    @KafkaListener(topics = "producer.topic", groupId = "publisher-group")
    public void handle(BookIsbnMessage message) {
        message.getIsbns()
                .stream()
                .map(i -> repository.findByIsbn(i).orElse(null))
                .filter(Objects::nonNull)
                .forEach(b -> {
                    b.setAmount(b.getAmount() - message.getAmount());
                    repository.save(b);
                });

        messagingService.sendMessageToTopic(message);
    }
}
