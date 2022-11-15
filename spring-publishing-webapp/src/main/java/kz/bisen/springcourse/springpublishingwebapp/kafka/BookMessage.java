package kz.bisen.springcourse.springpublishingwebapp.kafka;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kz.bisen.springcourse.springpublishingwebapp.dto.BookDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonSerialize
@Data
@NoArgsConstructor
public class BookMessage {
    private int amount;
    private BookDto bookDto;
}
