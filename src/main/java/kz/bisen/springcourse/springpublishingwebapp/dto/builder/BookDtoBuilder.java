package kz.bisen.springcourse.springpublishingwebapp.dto.builder;

import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import kz.bisen.springcourse.springpublishingwebapp.entity.Book;

public interface BookDtoBuilder {

    Book fromBookDto(BookDto bookDto);

    BookDto fromBook(Book book);
}
