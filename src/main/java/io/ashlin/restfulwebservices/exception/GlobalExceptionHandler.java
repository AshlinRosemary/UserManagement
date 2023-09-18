package io.ashlin.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "User_NOT_Found"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(
            EmailAlreadyExistsException exception, WebRequest webRequest){
        ErrorDetails errorDetails=new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_EMAIL_ALREADY EXISTS"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
