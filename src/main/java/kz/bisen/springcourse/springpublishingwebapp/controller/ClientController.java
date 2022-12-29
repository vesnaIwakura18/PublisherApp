package kz.bisen.springcourse.springpublishingwebapp.controller;

import kz.bisen.springcourse.springpublishingwebapp.dto.ClientDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl.DefaultClientDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Client;
import kz.bisen.springcourse.springpublishingwebapp.service.impl.DefaultClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final DefaultClientService service;

    private final DefaultClientDtoBuilder dtoBuilder;

    @Autowired
    public ClientController(DefaultClientService service, DefaultClientDtoBuilder dtoBuilder) {
        this.service = service;
        this.dtoBuilder = dtoBuilder;
    }

    @GetMapping
    public List<ClientDto> getAllPaginated(@RequestParam(value = "page") Integer page,
                                           @RequestParam(value = "size") Integer size,
                                           @RequestParam(value = "isSorted") Boolean isSorted) {
        final List<Client> clientsListPage = service.findAllPaginated(page, size, isSorted);

        return clientsListPage
                .stream()
                .map(dtoBuilder::fromClient)
                .toList();
    }

    @GetMapping("/{id}")
    public ClientDto getById(@PathVariable("id") Integer id) {
        final Client client = service.findById(id);

        return dtoBuilder.fromClient(client);
    }

    @PostMapping
    public ClientDto create(@RequestBody @Valid ClientDto clientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            service.throwNotValidFieldException(bindingResult);

        final Client client = dtoBuilder.fromClientDto(clientDto);

        return dtoBuilder.fromClient(service.save(client));
    }

    @PutMapping("/{id}")
    public ClientDto update(@PathVariable("id") Integer id,
                            @RequestBody @Valid ClientDto updatedClientDto,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            service.throwNotValidFieldException(bindingResult);

        final Client updatedClient = dtoBuilder.fromClientDto(updatedClientDto);

        return dtoBuilder.fromClient(service.update(id, updatedClient));
    }

    @DeleteMapping("/{id}")
    public Integer deleteById(@PathVariable("id") Integer id) {
        service.findById(id);

        return service.deleteById(id);
    }
}
