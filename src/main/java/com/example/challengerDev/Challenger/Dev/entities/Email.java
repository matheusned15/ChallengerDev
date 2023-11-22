package com.example.challengerDev.Challenger.Dev.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "Email")
@Data
public class Email {

    // Pelo menos um e-mail deve ser cadastrado
    @NotEmpty(message = "Pelo menos um e-mail deve ser cadastrado")
    private List<@Valid @javax.validation.constraints.Email(message = "E-mail inválido") String> emails;

    // Construtores, getters e setters

    // Exemplo de construtor
    public Email(List<String> emails) {
        this.emails = emails;
    }
}
