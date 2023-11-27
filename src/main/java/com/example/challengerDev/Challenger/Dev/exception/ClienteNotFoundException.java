package com.example.challengerDev.Challenger.Dev.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClienteNotFoundException extends RuntimeException {

    private final String message;

    public ClienteNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
