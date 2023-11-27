package com.example.challengerDev.Challenger.Dev.entities;

import com.example.challengerDev.Challenger.Dev.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles userRole;
}
