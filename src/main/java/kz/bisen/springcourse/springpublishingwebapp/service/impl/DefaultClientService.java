package kz.bisen.springcourse.springpublishingwebapp.service.impl;

import kz.bisen.springcourse.springpublishingwebapp.entity.Client;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotCreatedException;
import kz.bisen.springcourse.springpublishingwebapp.exception.NotFoundException;
import kz.bisen.springcourse.springpublishingwebapp.repository.ClientRepository;
import kz.bisen.springcourse.springpublishingwebapp.service.ClientService;
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
public class DefaultClientService implements ClientService {
    private final ClientRepository clientRepository;

    private final NotFoundException clientNotFoundException = new NotFoundException(HttpStatus.NOT_FOUND, "Client not found");

    @Autowired
    public DefaultClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAllPaginated(int page, int size, boolean isSorted) {
        final Sort ASC = Sort.by(Sort.Order.asc("name"));
        final Sort DESC = Sort.by(Sort.Order.desc("name"));

        return clientRepository.findAll(PageRequest.of(page, size, isSorted ? ASC : DESC)).getContent();
    }

    public Client findById(int id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> clientNotFoundException);
    }

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client update(int id, Client updatedClient) {
        updatedClient.setId(id);
        return clientRepository.save(updatedClient);
    }

    @Transactional
    public Integer deleteById(int id) {
        clientRepository.deleteById(id);
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
