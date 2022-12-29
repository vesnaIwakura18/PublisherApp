package kz.bisen.springcourse.springpublishingwebapp.service;

import kz.bisen.springcourse.springpublishingwebapp.entity.Author;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface AuthorService {
    List<Author> findAllPaginated(int page, int size, boolean isSorted);

    Author findById(int id);

    Author save(Author author);

    Author update(int id, Author updatedAuthor);

    Integer deleteById(int id);

    void throwNotValidFieldException(BindingResult bindingResult);

}
