package kz.bisen.springcourse.springpublishingwebapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotCreatedException extends ResponseStatusException {
    public NotCreatedException(HttpStatus status, String reason) {
        super(status, reason);
    }
}
