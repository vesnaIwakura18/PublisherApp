package kz.bisen.springcourse.springpublishingwebapp.controller;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.BookDtoList;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultBookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {
    private final DefaultBookService service;

    private final DefaultBookDtoBuilder dtoBuilder;

    @Autowired
    public BookController(DefaultBookService service, DefaultBookDtoBuilder dtoBuilder) {
        this.service = service;
        this.dtoBuilder = dtoBuilder;
    }

    @GetMapping
    public List<BookDto> getAllPaginated(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size, @RequestParam(value = "isSorted") Boolean isSorted) {
        final List<Book> booksListPage = service.findAllPaginated(page, size, isSorted);

        return booksListPage.stream().map(dtoBuilder::fromBook).toList();
    }

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable("id") Integer id) {
        final Book book = service.findById(id);

        return dtoBuilder.fromBook(book);
    }

    @PostMapping
    public BookDto create(@RequestBody @Valid BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) service.throwNotValidFieldException(bindingResult);

        final Book book = dtoBuilder.fromBookDto(bookDto);

        return dtoBuilder.fromBook(service.save(book));
    }

    @PutMapping("/{id}")
    public BookDto update(@PathVariable("id") Integer id, @RequestBody @Valid BookDto updatedBookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) service.throwNotValidFieldException(bindingResult);

        final Book updatedBook = dtoBuilder.fromBookDto(updatedBookDto);

        return dtoBuilder.fromBook(service.update(id, updatedBook));
    }

    @DeleteMapping("/{id}")
    public Integer deleteById(@PathVariable("id") Integer id) {
        service.findById(id);

        return service.deleteById(id);
    }

    @PostMapping("/isbn")
    public BookDtoList findAllByIsbn(@RequestBody List<String> isbns) {
        log.info("==========================================");
        log.info("isbn: {}", isbns);
        return new BookDtoList(
                isbns
                        .stream()
                        .map(service::findByIsbn)
                        .map(dtoBuilder::fromBook)
                        .toList()
        );
    }
}
