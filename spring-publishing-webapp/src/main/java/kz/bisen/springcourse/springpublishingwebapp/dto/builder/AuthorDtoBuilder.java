package kz.bisen.springcourse.springpublishingwebapp.dto.builder;

import kz.bisen.springcourse.springpublishingwebapp.dto.AuthorDto;
import kz.bisen.springcourse.springpublishingwebapp.entity.Author;

public interface AuthorDtoBuilder {

    Author fromAuthorDto(AuthorDto authorDto);

    AuthorDto fromAuthor(Author author);
}
