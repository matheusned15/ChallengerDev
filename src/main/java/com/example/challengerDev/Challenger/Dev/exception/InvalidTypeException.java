package com.example.challengerDev.Challenger.Dev.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvalidTypeException extends RuntimeException{

    private final String message;

    public InvalidTypeException(String message) {
        super(message);
        this.message = message;
    }
}
