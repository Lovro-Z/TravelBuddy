package zubcic.travel.travelapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<String> handleInvalidUserException() {
        return new ResponseEntity<>("invalid-user", HttpStatus.UNPROCESSABLE_ENTITY);
    }


    @ExceptionHandler(ExistingUsernameException.class)
    public ResponseEntity<String> handleExistingUsernameException() {
        return new ResponseEntity<>("existing-user", HttpStatus.CONFLICT);
    }
}
