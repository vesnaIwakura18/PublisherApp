package kz.bisen.springcourse.springpublishingwebapp.dto.builder;

import kz.bisen.springcourse.springpublishingwebapp.dto.PublisherDto;
import kz.bisen.springcourse.springpublishingwebapp.entity.Publisher;

public interface PublisherDtoBuilder {

    Publisher fromPublisherDto(PublisherDto publisherDto);

    PublisherDto fromPublisher(Publisher publisher);
}
