package lk.coop.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String errorMessage){
        super(errorMessage);
    }

}
