package lk.coop.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AuthorityException extends RuntimeException {

    public AuthorityException(String errorMessage){
        super(errorMessage);
    }

}