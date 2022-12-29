package kz.bisen.springcourse.springpublishingwebapp.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseError handle(ResponseStatusException exception) {
        log.error(exception.getMessage(), exception);
        return new ResponseError(exception.getMessage(), exception.getStatus());
    }
}
