package academy.devdojo.handler;

import academy.devdojo.exception.AnimeException;
import academy.devdojo.exception.AnimeExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(AnimeException.class)
    public ResponseEntity<AnimeExceptionDetails> handlerAnimeException(AnimeException animeException){

        return  new ResponseEntity<>(AnimeExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request verifique sua documentacao")
                .details(animeException.getMessage())
                .developerMessage(animeException.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST );

    }
}
