package zubcic.travel.travelapplication.exception;

import org.springframework.http.HttpStatus;

public class InvalidUserException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus httpStatus;

    public InvalidUserException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
