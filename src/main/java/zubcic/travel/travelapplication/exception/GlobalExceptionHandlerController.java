package zubcic.travel.travelapplication.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidUserException.class)
    public void handleInvalidUserException(HttpServletResponse res, InvalidUserException ex) throws Exception {
        res.sendError(ex.getHttpStatus().value(), ex.getMessage());
    }

    @ExceptionHandler(ExistingUsernameException.class)
    public void handleExistingUsernameException(HttpServletResponse res, ExistingUsernameException ex) throws Exception {
        res.sendError(ex.getHttpStatus().value(), ex.getMessage());
    }
}
