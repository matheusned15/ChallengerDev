package com.example.challengerDev.Challenger.Dev.entities;

import com.example.challengerDev.Challenger.Dev.utils.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Email extends BaseEntity {

    @NotEmpty
    @javax.validation.constraints.Email
    private String email;

    @ManyToOne
    @JsonIgnore
    private Client client;

}
