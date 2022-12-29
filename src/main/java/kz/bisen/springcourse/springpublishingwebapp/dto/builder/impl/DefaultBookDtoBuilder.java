package kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DefaultBookDtoBuilder /*implements BookDtoBuilder*/ {
    private final AuthorRepository authorRepository;

    @Autowired
    public DefaultBookDtoBuilder(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public BookDto fromBook(Book book) {
        return new BookDto(
                book.getTitle(),
                book.getIssueDateTime(),
                book.getAmount(),
                0,
                book.getIsbn(),
                book.getAuthor().getFirstName(),
                book.getAuthor().getLastName()
        );
    }

    public Book fromBookDto(BookDto bookDTO) {
        return new Book(bookDTO.getTitle(),
                bookDTO.getIssueDateTime(),
                0,
                bookDTO.getIsbn(),
                LocalDateTime.now(),
                authorRepository.findByFirstNameAndLastName(
                                bookDTO.getAuthorFirstName(),
                                bookDTO.getAuthorLastName()
                        )
                        .orElse(null));
    }
}
