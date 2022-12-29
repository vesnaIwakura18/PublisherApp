package kz.bisen.springcourse.springpublishingwebapp.dto;

import kz.bisen.springcourse.springpublishingwebapp.entity.Book;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class ClientDto {

    @NotEmpty(message = "Name must not be empty")
    @Size(max = 30, message = "Name length must not be greater than 30 characters")
    private String name;

    @ManyToMany(mappedBy = "clients")
    private List<Book> books;

    public ClientDto(String name) {
        this.name = name;
    }

    public ClientDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
