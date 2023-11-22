package com.example.challengerDev.Challenger.Dev.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "phone")
@Data
public class Phone {

    @NotBlank(message = "Número de telefone é obrigatório")
    @Pattern(regexp = "\\d{10,11}", message = "Número de telefone inválido")
    private String number;

    // Padrão para validar números de telefone (sem contar com a máscara)
    private static final String DEFAULT_PHONE_NUMBER = "\\d{8,9}";

    // Tipo de telefone (residencial, comercial, celular)
    private PhoneType type;

    public Phone(String number) {
        this.number = number;
    }

}
