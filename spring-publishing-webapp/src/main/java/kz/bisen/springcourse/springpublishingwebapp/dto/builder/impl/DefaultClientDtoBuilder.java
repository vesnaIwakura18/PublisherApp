package kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.ClientDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.ClientDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class DefaultClientDtoBuilder implements ClientDtoBuilder {
    public Client fromClientDto(ClientDto clientDto) {
        return new Client(clientDto.getName());
    }

    public ClientDto fromClient(Client client) {
        return new ClientDto(client.getName());
    }
}
