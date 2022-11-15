package kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.PublisherDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.PublisherDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
public class DefaultPublisherDtoBuilder implements PublisherDtoBuilder {

    public Publisher fromPublisherDto(PublisherDto publisherDto) {
        return new Publisher(publisherDto.getFirstName(), publisherDto.getLastName());
    }

    public PublisherDto fromPublisher(Publisher publisher) {
        return new PublisherDto(publisher.getFirstName(), publisher.getLastName());
    }
}
