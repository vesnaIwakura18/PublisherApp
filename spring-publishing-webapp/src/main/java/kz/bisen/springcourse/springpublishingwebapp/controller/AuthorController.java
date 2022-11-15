package kz.bisen.springcourse.springpublishingwebapp.controller;

import kz.bisen.springcourse.springpublishingwebapp.dto.AuthorDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultAuthorDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Author;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final DefaultAuthorService service;

    private final DefaultAuthorDtoBuilder dtoBuilder;

    @Autowired
    public AuthorController(DefaultAuthorService service, DefaultAuthorDtoBuilder dtoBuilder) {
        this.service = service;
        this.dtoBuilder = dtoBuilder;
    }

    @GetMapping
    public List<AuthorDto> getAllPaginated(@RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "size") Integer size,
                                           @RequestParam(value = "isSorted") Boolean isSorted) {
        final List<Author> authorsListPage = service.findAllPaginated(page, size, isSorted);

        return authorsListPage
                .stream()
                .map(dtoBuilder::fromAuthor)
                .toList();
    }

    @GetMapping("/{id}")
    public AuthorDto getById(@PathVariable("id") Integer id) {
        final Author author = service.findById(id);

        return dtoBuilder.fromAuthor(author);
    }

    @PostMapping
    public AuthorDto create(@RequestBody @Valid AuthorDto authorDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            service.throwNotValidFieldException(bindingResult);

        final Author author = dtoBuilder.fromAuthorDto(authorDto);

        return dtoBuilder.fromAuthor(service.save(author));
    }

    @PutMapping("/{id}")
    public AuthorDto update(@PathVariable("id") Integer id,
                            @RequestBody @Valid AuthorDto updatedAuthorDto,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            service.throwNotValidFieldException(bindingResult);

        final Author updatedAuthor = dtoBuilder.fromAuthorDto(updatedAuthorDto);

        return dtoBuilder.fromAuthor(service.update(id, updatedAuthor));
    }

    @DeleteMapping("/{id}")
    public Integer deleteById(@PathVariable("id") Integer id) {
        service.findById(id);

        return service.deleteById(id);
    }
}
