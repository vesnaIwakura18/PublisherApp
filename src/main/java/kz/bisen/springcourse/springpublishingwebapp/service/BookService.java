package kz.bisen.springcourse.springpublishingwebapp.service;

import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface BookService {
    List<Book> findAllPaginated(int page, int size, boolean isSorted);

    Book findById(Integer id);

    Book save(Book book);

    Book update(Integer id, Book updatedBook);

    Integer deleteById(Integer id);

    void throwNotValidFieldException(BindingResult bindingResult);

}
