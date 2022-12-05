package kz.bisen.springcourse.springpublishingwebapp.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class BookDto {
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 100, message = "Title length must not be greater than 100 characters")
    private String title;

    @NotNull(message = "Issue year must not be empty")
    private LocalDateTime issueDateTime;

    @NotNull(message = "amount must not be null")
    private int amount;

    @NotEmpty
    private String isbn;

    private Integer minAmount;

    @NotNull
    private String authorFirstName;

    @NotNull
    private String authorLastName;

    public BookDto(
            String title,
            LocalDateTime issueDateTime,
            Integer amount,
            Integer minAmount,
            String isbn,
            String authorFirstName,
            String authorLastName
    ) {
        this.title = title;
        this.issueDateTime = issueDateTime;
        this.amount = amount;
        this.minAmount = minAmount;
        this.isbn = isbn;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public void setIssueDateTime(LocalDateTime issueDateTime) {
        this.issueDateTime = issueDateTime;
    }
}

