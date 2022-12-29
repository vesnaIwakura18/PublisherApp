package kz.bisen.springcourse.springpublishingwebapp.controller;

import kz.bisen.springcourse.springpublishingwebapp.entity.BookClient;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultBookClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book-client")
public class BookClientController {
    private final DefaultBookClientService service;

    @Autowired
    public BookClientController(DefaultBookClientService service) {
        this.service = service;
    }

    @PostMapping
    public BookClient save(@RequestBody BookClient bookClient) {
        service.save(bookClient);

        return bookClient;
    }

    @DeleteMapping
    public Integer delete(Integer id) {
        service.deleteById(id);

        return id;
    }
}
