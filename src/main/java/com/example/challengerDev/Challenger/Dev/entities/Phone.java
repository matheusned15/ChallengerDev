package com.example.challengerDev.Challenger.Dev.entities;

import com.example.challengerDev.Challenger.Dev.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Phone extends BaseEntity {

    @NotBlank(message = "Número de telefone é obrigatório")
    @Pattern(regexp = "\\d{10,11}", message = "Número de telefone inválido")
    private String number;

    // Padrão para validar números de telefone (sem contar com a máscara)
    private static final String DEFAULT_PHONE_NUMBER = "\\d{8,9}";

    // Tipo de telefone (residencial, comercial, celular)
    private PhoneType type;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Phone(String number) {
        this.number = number;
    }

}
