package kz.bisen.springcourse.springpublishingwebapp.kafka.producer;

import kz.bisen.springcourse.springpublishingwebapp.kafka.BookIsbnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookQuantityProducer {
    private final KafkaTemplate<String, BookIsbnMessage> kafkaTemplate;

    @Autowired
    public BookQuantityProducer(KafkaTemplate<String, BookIsbnMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToTopic(BookIsbnMessage message) {
        kafkaTemplate.send("library.topic", message);
    }
}
