package kz.bisen.springcourse.springpublishingwebapp.dto;

import java.util.ArrayList;
import java.util.List;

public class BookDtoList {
    private List<BookDto> bookDtos;

    public BookDtoList(List<BookDto> bookDtos) {
        this.bookDtos = bookDtos;
    }

    public BookDtoList() {
    }

    public List<BookDto> getBookDtos() {
        return bookDtos;
    }

    public void setBookDtos(List<BookDto> bookDtos) {
        this.bookDtos = bookDtos;
    }
}
