package kz.bisen.springcourse.springpublishingwebapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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
    private LocalDateTime issueDateTime;

    @NotNull(message = "amount must not be null")
    private int amount;

    @NotEmpty
    private String isbn;

    public BookDto(String title, LocalDateTime issueDateTime, int amount, String isbn) {
        this.title = title;
        this.issueDateTime = issueDateTime;
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

    public LocalDateTime getIssueDateTime() {
        return issueDateTime;
    }

    public void setIssueDateTime(LocalDateTime issueDateTime) {
        this.issueDateTime = issueDateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", issueDateTime=" + issueDateTime +
                ", amount=" + amount +
                '}';
    }
}

