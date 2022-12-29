package kz.bisen.springcourse.springpublishingwebapp.soap.builder;

import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.soap.dto.SoapBook;
import org.springframework.stereotype.Component;

@Component
public class SoapBookBuilder {
    public SoapBook fromBook(Book book) {
        return new SoapBook(
                book.getTitle(),
                book.getIssueDateTime().toString(),
                book.getAmount(),
                book.getIsbn(),
                0,
                book.getAuthor().getFirstName(),
                book.getAuthor().getLastName()
        );
    }
}
