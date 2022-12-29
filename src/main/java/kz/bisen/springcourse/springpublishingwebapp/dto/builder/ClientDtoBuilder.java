package kz.bisen.springcourse.springpublishingwebapp.dto.builder;

import kz.bisen.springcourse.springpublishingwebapp.dto.ClientDto;
import kz.bisen.springcourse.springpublishingwebapp.entity.Client;

public interface ClientDtoBuilder {
    Client fromClientDto(ClientDto clientDto);

    ClientDto fromClient(Client client);
}
