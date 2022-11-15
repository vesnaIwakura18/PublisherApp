package kz.bisen.springcourse.springpublishingwebapp.service.impl;

import kz.bisen.springcourse.springpublishingwebapp.entity.Publisher;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotCreatedException;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotFoundException;
import kz.bisen.springcourse.springpublishingwebapp.repository.PublisherRepository;
import kz.bisen.springcourse.springpublishingwebapp.service.PublisherService;
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
public class DefaultPublisherService implements PublisherService {
    private final PublisherRepository publisherRepository;

    private final NotFoundException employeeNotFoundException = new NotFoundException(HttpStatus.NOT_FOUND, "Publisher not found");

    @Autowired
    public DefaultPublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> findAllPaginated(int page, int size, boolean isSorted) {
        Sort asc = Sort.by(Sort.Order.asc("firstName"));
        Sort desc = Sort.by(Sort.Order.desc("firstName"));

        return publisherRepository.findAll(PageRequest.of(page, size, isSorted ? asc : desc)).getContent();
    }

    public Publisher findById(int id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> employeeNotFoundException);
    }

    @Transactional
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Transactional
    public Publisher update(int id, Publisher updatedPublisher) {
        updatedPublisher.setId(id);
        return publisherRepository.save(updatedPublisher);
    }

    @Transactional
    public Integer deleteById(int id) {
        publisherRepository.deleteById(id);
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
