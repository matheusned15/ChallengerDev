package com.example.challengerDev.Challenger.Dev.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public enum PhoneType {
    RESIDENCIAL, COMERCIAL, CELULAR;

    @JsonCreator
    public static PhoneType fromValue(final String value) {
        if (value.equalsIgnoreCase("residencial")) {
            return PhoneType.RESIDENCIAL;
        }

        if (value.equalsIgnoreCase("comercial")) {
            return PhoneType.COMERCIAL;
        }

        if (value.equalsIgnoreCase("celular")) {
            return PhoneType.CELULAR;
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "TipoTelefone: " + value + " Nao encontrado");
    }
}
