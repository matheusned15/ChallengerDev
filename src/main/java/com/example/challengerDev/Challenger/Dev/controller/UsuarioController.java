package com.example.challengerDev.Challenger.Dev.controller;

import com.example.challengerDev.Challenger.Dev.dto.Login;
import com.example.challengerDev.Challenger.Dev.entities.Client;
import com.example.challengerDev.Challenger.Dev.entities.Usuario;
import com.example.challengerDev.Challenger.Dev.service.TokenService;
import com.example.challengerDev.Challenger.Dev.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/login")
    public String login(@RequestBody Login login){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.login(),
                login.password());

        Authentication authentication =  this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Client) authentication.getPrincipal();

        return tokenService.gerarToken(usuario);
    }
}
