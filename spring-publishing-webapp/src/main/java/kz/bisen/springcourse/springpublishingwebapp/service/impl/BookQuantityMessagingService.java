package kz.bisen.springcourse.springpublishingwebapp.service.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookQuantityMessagingService {
    private final KafkaTemplate<String, BookDto> kafkaTemplate;

    @Autowired
    public BookQuantityMessagingService(KafkaTemplate<String, BookDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(BookDto order) {
        kafkaTemplate.send("test2", order);
    }
}
