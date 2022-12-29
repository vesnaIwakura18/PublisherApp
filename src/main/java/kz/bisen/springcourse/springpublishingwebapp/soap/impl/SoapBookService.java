package kz.bisen.springcourse.springpublishingwebapp.soap.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultBookDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import kz.bisen.springcourse.springpublishingwebapp.soap.builder.SoapBookBuilder;
import kz.bisen.springcourse.springpublishingwebapp.soap.dto.SoapBook;
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

    private final SoapBookBuilder builder;

    @Autowired
    public SoapBookService(BookRepository bookRepository, SoapBookBuilder builder) {
        this.bookRepository = bookRepository;
        this.builder = builder;
    }

    @WebMethod(operationName = "get-books")
    public List<SoapBook> getBooks(List<String> isbns) {
        final List<Book> foundBooks =
                isbns
                        .stream()
                        .map(b -> bookRepository.findByIsbn(b).orElse(null))
                        .toList();
        return foundBooks.stream().map(builder::fromBook).toList();
    }
}
