package com.ikub.jdbc.springbootjdbc.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BlogExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoungException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundExceptions(UserNotFoungException userEx, HttpServletRequest req) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timstamp(LocalDateTime.now())
                .path(req.getRequestURI())
                .errorCode(HttpStatus.NOT_FOUND.value())
                .message(userEx.getLocalizedMessage()).build();
        return ResponseEntity.ok(errorDetails);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleUserAlreadyExistsExceptions(UserAlreadyExistsException userEx, HttpServletRequest req) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timstamp(LocalDateTime.now())
                .path(req.getRequestURI())
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .message(userEx.getLocalizedMessage()).build();
        return ResponseEntity.ok(errorDetails);
    }


    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleCategoryNotFoundException(CategoryNotFoundException catExc, HttpServletRequest req){
            ErrorDetails errorDetails = ErrorDetails.builder()
                    .timstamp(LocalDateTime.now())
                    .path(req.getRequestURI())
                    .errorCode(HttpStatus.NOT_FOUND.value())
                    .message(catExc.getLocalizedMessage()).build();
        return ResponseEntity.ok(errorDetails);
    }


    @ExceptionHandler(PostNotFoungException.class)
    public ResponseEntity<ErrorDetails> handleCategoryNotFoundException(PostNotFoungException postNTFound, HttpServletRequest req){
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timstamp(LocalDateTime.now())
                .path(req.getRequestURI())
                .errorCode(HttpStatus.NOT_FOUND.value())
                .message(postNTFound.getLocalizedMessage()).build();
        return ResponseEntity.ok(errorDetails);
    }
}
