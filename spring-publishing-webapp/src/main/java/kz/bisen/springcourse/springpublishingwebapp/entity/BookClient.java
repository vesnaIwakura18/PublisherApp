package kz.bisen.springcourse.springpublishingwebapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "book_client")
public class BookClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "client_id")
    private Integer clientId;

    public BookClient(Integer id, Integer bookId, Integer clientId) {
        this.id = id;
        this.bookId = bookId;
        this.clientId = clientId;
    }

    public BookClient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
}
