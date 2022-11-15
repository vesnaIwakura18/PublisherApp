package kz.bisen.springcourse.springpublishingwebapp.dto;

import kz.bisen.springcourse.springpublishingwebapp.entity.Author;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookDto {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty(message = "Title must not be empty")
    @Size(max = 100, message = "Title length must not be greater than 100 characters")
    private String title;

    @NotNull(message = "Issue year must not be empty")
    private int issueYear;

    @NotNull(message = "author must not be empty")
    private AuthorDto author;

    public BookDto(String title, int issueYear, AuthorDto author) {
        this.title = title;
        this.issueYear = issueYear;
        this.author = author;
    }

    public BookDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
