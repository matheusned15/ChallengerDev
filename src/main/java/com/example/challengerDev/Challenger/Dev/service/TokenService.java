package com.example.challengerDev.Challenger.Dev.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.example.challengerDev.Challenger.Dev.entities.Client;
import com.example.challengerDev.Challenger.Dev.entities.Usuario;
import com.auth0.jwt.JWT;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Client usuario) {
        return JWT.create()
                .withIssuer("Produtos")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(30)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("secreta"));
    }


    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256("secreta"))
                .withIssuer("Produtos")
                .build().verify(token).getSubject();

    }
}
