package kz.bisen.springcourse.springpublishingwebapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@SecondaryTable(name = "book_scan", pkJoinColumns = @PrimaryKeyJoinColumn(name = "book_id", referencedColumnName = "id"))
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 100, message = "Title length must not be greater than 100 characters")
    private String title;

    @Column(name = "issue_datetime")
    @NotNull
    private LocalDateTime issueDateTime;

    @Column
    private int amount;

    @Column
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @Column(table = "book_scan")
    private LocalDateTime scannedDateTime;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book(String title, LocalDateTime issueDateTime, int amount, String isbn, LocalDateTime scannedDateTime, Author author) {
        this.title = title;
        this.issueDateTime = issueDateTime;
        this.amount = amount;
        this.isbn = isbn;
        this.scannedDateTime = scannedDateTime;
        this.author = author;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDateTime getScannedDateTime() {
        return scannedDateTime;
    }

    public void setScannedDateTime(LocalDateTime scannedDateTime) {
        this.scannedDateTime = scannedDateTime;
    }
}
