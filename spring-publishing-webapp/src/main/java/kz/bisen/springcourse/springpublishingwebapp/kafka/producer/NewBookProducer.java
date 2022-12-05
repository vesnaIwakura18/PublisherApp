package kz.bisen.springcourse.springpublishingwebapp.kafka.producer;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewBookProducer {
    private final KafkaTemplate<String, List<BookDto>> kafkaTemplate;

    @Autowired
    public NewBookProducer(KafkaTemplate<String, List<BookDto>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(List<BookDto> bookDtos) {
        kafkaTemplate.send("library.topic", bookDtos);
    }

    // todo SELECT b.scan_datetime from Book_scan b ORDERED BY b.scan_datetime desc;
    // todo SELECT book from Book where issue_datetime > scan_datetime;
}
