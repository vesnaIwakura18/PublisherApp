package kz.bisen.springcourse.springpublishingwebapp.service;

import kz.bisen.springcourse.springpublishingwebapp.entity.Publisher;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface PublisherService {
    List<Publisher> findAllPaginated(int page, int size, boolean isSorted);

    Publisher findById(int id);

    Publisher save(Publisher publisher);

    Publisher update(int id, Publisher updatedPublisher);

    Integer deleteById(int id);

    void throwNotValidFieldException(BindingResult bindingResult);

}
