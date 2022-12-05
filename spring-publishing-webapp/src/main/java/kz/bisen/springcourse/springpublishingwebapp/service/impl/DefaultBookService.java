package kz.bisen.springcourse.springpublishingwebapp.service.impl;

import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotCreatedException;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotFoundException;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookRepository;
import kz.bisen.springcourse.springpublishingwebapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DefaultBookService implements BookService {
    private final BookRepository bookRepository;

    private final NotFoundException bookNotFoundException = new NotFoundException(HttpStatus.NOT_FOUND, "Book not found");

    @Autowired
    public DefaultBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllPaginated(int page, int size, boolean isSorted) {
        Sort asc = Sort.by(Sort.Order.asc("title"));
        Sort desc = Sort.by(Sort.Order.desc("title"));

        return bookRepository.findAll(PageRequest.of(page, size, isSorted ? asc : desc)).getContent();
    }

    public Book findById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> bookNotFoundException);
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book update(Integer id, Book updatedBook) {
        updatedBook.setId(id);
        return bookRepository.save(updatedBook);
    }

    @Transactional
    public Integer deleteById(Integer id) {
        bookRepository.deleteById(id);
        return id;
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> bookNotFoundException);
    }

    public void throwNotValidFieldException(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder errorMsg = new StringBuilder();

        fieldErrors
                .forEach(e -> errorMsg.append(e.getField()).append(" - ").append(e.getDefaultMessage()));

        throw new NotCreatedException(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg.toString());
    }
}
