package academy.devdojo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnimeException extends RuntimeException{
    //Sempre Retornar BadRequest
    public AnimeException(String msg) {
        super(msg);
    }
}
