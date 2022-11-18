package kz.bisen.springcourse.springpublishingwebapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDto {
    private Integer id;

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

    @NotNull(message = "amount must not be null")
    private int amount;

    @NotEmpty
    private String isbn;

    public BookDto(String title, int issueYear, int amount, String isbn) {
        this.title = title;
        this.issueYear = issueYear;
        this.amount = amount;
        this.isbn = isbn;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", issueYear=" + issueYear +
                ", amount=" + amount +
                '}';
    }
}

