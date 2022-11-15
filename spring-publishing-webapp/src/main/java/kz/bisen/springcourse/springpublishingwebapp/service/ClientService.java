package kz.bisen.springcourse.springpublishingwebapp.service;

import kz.bisen.springcourse.springpublishingwebapp.entity.Client;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ClientService {
    List<Client> findAllPaginated(int page, int size, boolean isSorted);

    Client findById(int id);

    Client save(Client client);

    Client update(int id, Client updatedClient);

    Integer deleteById(int id);

    void throwNotValidFieldException(BindingResult bindingResult);

}
