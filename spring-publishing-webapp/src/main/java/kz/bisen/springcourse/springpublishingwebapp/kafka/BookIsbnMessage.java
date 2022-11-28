package kz.bisen.springcourse.springpublishingwebapp.kafka;

import lombok.Data;

import java.util.List;

@Data
public class BookIsbnMessage {
    private List<String> isbns;

    private int amount;

    private String partition;

    public BookIsbnMessage(List<String> isbns,
                           int amount,
                           String partition) {
        this.isbns = isbns;
        this.amount = amount;
        this.partition = partition;
    }

    public BookIsbnMessage() {}

    public static BookIsbnMessage of(List<String> isbns, int amount) {
        return new BookIsbnMessage(isbns, amount, "publisher-group");
    }

    @Override
    public String toString() {
        return "BookIsbnMessage{" +
                "isbn=" + isbns +
                ", amount=" + amount +
                '}';
    }
}
