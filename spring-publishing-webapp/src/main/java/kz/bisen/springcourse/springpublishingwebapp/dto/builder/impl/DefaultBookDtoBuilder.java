package kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.BookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultBookDtoBuilder implements BookDtoBuilder {
    private final DefaultAuthorDtoBuilder authorDtoBuilder;

    @Autowired
    public DefaultBookDtoBuilder(DefaultAuthorDtoBuilder authorDtoBuilder) {
        this.authorDtoBuilder = authorDtoBuilder;
    }

    public Book fromBookDto(BookDto bookDto) {
        return new Book(bookDto.getTitle(),
                bookDto.getIssueYear(),
                authorDtoBuilder.fromAuthorDto(bookDto.getAuthor()));
    }

    public BookDto fromBook(Book book) {
        return new BookDto(book.getTitle(),
                book.getIssueYear(),
                authorDtoBuilder.fromAuthor(book.getAuthor()));
    }
}
