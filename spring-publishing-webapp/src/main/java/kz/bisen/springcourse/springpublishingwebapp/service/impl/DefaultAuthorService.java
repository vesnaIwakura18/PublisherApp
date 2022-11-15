package kz.bisen.springcourse.springpublishingwebapp.service.impl;

import kz.bisen.springcourse.springpublishingwebapp.entity.Author;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotCreatedException;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotFoundException;
import kz.bisen.springcourse.springpublishingwebapp.repository.AuthorRepository;
import kz.bisen.springcourse.springpublishingwebapp.service.AuthorService;
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
public class DefaultAuthorService implements AuthorService {
    private final AuthorRepository authorRepository;

    private final NotFoundException authorNotFoundException = new NotFoundException(HttpStatus.NOT_FOUND, "Author not found");

    @Autowired
    public DefaultAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAllPaginated(int page, int size, boolean isSorted) {
        final Sort ASC = Sort.by(Sort.Order.asc("firstName"));
        final Sort DESC = Sort.by(Sort.Order.desc("firstName"));

        return authorRepository.findAll(PageRequest.of(page, size, isSorted ? ASC : DESC)).getContent();
    }

    public Author findById(int id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> authorNotFoundException);
    }

    @Transactional
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author update(int id, Author updatedAuthor) {
        updatedAuthor.setId(id);

        return authorRepository.save(updatedAuthor);
    }

    @Transactional
    public Integer deleteById(int id) {
        authorRepository.deleteById(id);

        return id;
    }

    public void throwNotValidFieldException(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder errorMsg = new StringBuilder();

        fieldErrors
                .forEach(e -> errorMsg.append(e.getField()).append(" - ").append(e.getDefaultMessage()));

        throw new NotCreatedException(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg.toString());
    }
}
