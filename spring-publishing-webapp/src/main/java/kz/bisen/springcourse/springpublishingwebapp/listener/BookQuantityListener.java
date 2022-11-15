package kz.bisen.springcourse.springpublishingwebapp.listener;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.BookQuantityMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookQuantityListener {
    private final BookQuantityMessagingService messagingService;

    @Autowired
    public BookQuantityListener(BookQuantityMessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @KafkaListener(topics = "test")
    public void handle(BookDto order) {
        messagingService.sendOrder(order);
    }
}
