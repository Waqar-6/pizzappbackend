package com.w_farooq_group.slicemagic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PizzaAlreadyExistsException extends RuntimeException{

    public PizzaAlreadyExistsException(String message) {
        super(message);
    }
}
