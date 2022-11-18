package kz.bisen.springcourse.springpublishingwebapp.kafka;

import lombok.Data;

import java.util.List;

@Data
public class BookIsbnMessage {
    private List<String> isbns;

    private int amount;

    public BookIsbnMessage(List<String> isbns, int amount) {
        this.isbns = isbns;
        this.amount = amount;
    }

    public BookIsbnMessage() {}

    public static BookIsbnMessage of(List<String> isbns, int amount) {
        return new BookIsbnMessage(isbns, amount);
    }

    @Override
    public String toString() {
        return "BookIsbnMessage{" +
                "isbn=" + isbns +
                ", amount=" + amount +
                '}';
    }
}
