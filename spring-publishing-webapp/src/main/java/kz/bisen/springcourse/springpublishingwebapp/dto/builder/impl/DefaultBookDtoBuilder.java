package kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.BookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DefaultBookDtoBuilder implements BookDtoBuilder {

    public Book fromBookDto(BookDto bookDto) {
        return new Book(bookDto.getTitle(),
                bookDto.getIssueDateTime(),
                bookDto.getAmount(),
                bookDto.getIsbn());
    }

    public BookDto fromBook(Book book) {
        return new BookDto(book.getTitle(),
                book.getIssueDateTime(),
                book.getAmount(),
                book.getIsbn());
    }
}
