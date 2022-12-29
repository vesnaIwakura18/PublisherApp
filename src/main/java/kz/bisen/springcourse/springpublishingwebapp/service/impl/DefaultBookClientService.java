package kz.bisen.springcourse.springpublishingwebapp.service.impl;

import kz.bisen.springcourse.springpublishingwebapp.entity.BookClient;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotCreatedException;
import kz.bisen.springcourse.springpublishingwebapp.repository.BookClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DefaultBookClientService {
    private final BookClientRepository bookClientRepository;

    @Autowired
    public DefaultBookClientService(BookClientRepository bookClientRepository) {
        this.bookClientRepository = bookClientRepository;
    }

    @Transactional
    public BookClient save(BookClient bookClient) {
        return bookClientRepository.save(bookClient);
    }

    @Transactional
    public Integer deleteById(int id) {
        bookClientRepository.deleteById(id);

        return id;
    }

    public void throwNotValidFieldException(BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder errorMsg = new StringBuilder();

        fieldErrors
                .forEach(e -> errorMsg
                        .append(e.getField())
                        .append(" - ")
                        .append(e.getDefaultMessage()));

        throw new NotCreatedException(HttpStatus.UNPROCESSABLE_ENTITY, errorMsg.toString());
    }
}
