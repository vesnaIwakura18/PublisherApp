package kz.bisen.springcourse.springpublishingwebapp.controller;

import kz.bisen.springcourse.springpublishingwebapp.dto.PublisherDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultPublisherDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Publisher;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private final DefaultPublisherService service;

    private final DefaultPublisherDtoBuilder dtoBuilder;

    @Autowired
    public PublisherController(DefaultPublisherService service, DefaultPublisherDtoBuilder dtoBuilder) {
        this.service = service;
        this.dtoBuilder = dtoBuilder;
    }

    @GetMapping
    public List<PublisherDto> getAllPaginated(@RequestParam(value = "page") Integer page,
                                              @RequestParam(value = "size") Integer size,
                                              @RequestParam(value = "isSorted") Boolean isSorted) {
        final List<Publisher> publishersListPage = service.findAllPaginated(page, size, isSorted);

        return publishersListPage
                .stream()
                .map(dtoBuilder::fromPublisher)
                .toList();
    }

    @GetMapping("/{id}")
    public PublisherDto getById(@PathVariable("id") Integer id) {
        final Publisher publisher = service.findById(id);

        return dtoBuilder.fromPublisher(publisher);
    }

    @PostMapping
    public PublisherDto create(@RequestBody @Valid PublisherDto publisherDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            service.throwNotValidFieldException(bindingResult);

        final Publisher publisher = dtoBuilder.fromPublisherDto(publisherDto);

        return dtoBuilder.fromPublisher(service.save(publisher));
    }

    @PutMapping("/{id}")
    public PublisherDto update(@PathVariable("id") Integer id,
                               @RequestBody @Valid PublisherDto updatedPublisherDto,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            service.throwNotValidFieldException(bindingResult);

        final Publisher updatedPublisher = dtoBuilder.fromPublisherDto(updatedPublisherDto);

        return dtoBuilder.fromPublisher(service.update(id, updatedPublisher));
    }

    @DeleteMapping("/{id}")
    public Integer deleteById(@PathVariable("id") Integer id) {
        service.findById(id);

        return service.deleteById(id);
    }
}
