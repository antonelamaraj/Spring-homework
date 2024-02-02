package com.ikub.jdbc.springbootjdbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoungException  extends RuntimeException{

    public UserNotFoungException(String message) {
        super(message);
    }
}
