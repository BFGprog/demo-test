package com.example.demo_test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException404 extends RuntimeException {

    public ObjectNotFoundException404(String message) {
        super(message);
    }
}
