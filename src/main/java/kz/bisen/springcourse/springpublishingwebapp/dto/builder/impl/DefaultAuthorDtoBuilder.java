package kz.bisen.springcourse.springpublishingwebapp.dto.builder.impl;

import kz.bisen.springcourse.springpublishingwebapp.dto.AuthorDto;
import kz.bisen.springcourse.springpublishingwebapp.dto.builder.AuthorDtoBuilder;
import kz.bisen.springcourse.springpublishingwebapp.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class DefaultAuthorDtoBuilder implements AuthorDtoBuilder {

    public Author fromAuthorDto(AuthorDto authorDto) {
        return new Author(authorDto.getFirstName(), authorDto.getLastName());
    }

    public AuthorDto fromAuthor(Author author) {
        return new AuthorDto(author.getFirstName(), author.getLastName());
    }
}
