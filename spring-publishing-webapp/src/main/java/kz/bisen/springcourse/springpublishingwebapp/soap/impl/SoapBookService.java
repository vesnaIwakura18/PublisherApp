package kz.bisen.springcourse.springpublishingwebapp.soap.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultBookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(
        serviceName = "SoapBookService"
)
@Service
public class SoapBookService {
    private final BookRepository bookRepository;

    private final DefaultBookDtoBuilder bookDtoBuilder;

    @Autowired
    public SoapBookService(BookRepository bookRepository, DefaultBookDtoBuilder bookDtoBuilder) {
        this.bookRepository = bookRepository;
        this.bookDtoBuilder = bookDtoBuilder;
    }

    @WebMethod(operationName = "get-books")
    public List<BookDto> getBooks(List<String> isbns) {
        final List<Book> foundBooks =
                isbns
                        .stream()
                        .map(b -> bookRepository.findByIsbn(b).orElse(null))
                        .toList();
        return foundBooks.stream().map(bookDtoBuilder::fromBook).toList();
    }
}
