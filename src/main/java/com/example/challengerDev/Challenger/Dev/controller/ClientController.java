package com.example.challengerDev.Challenger.Dev.controller;

import com.example.challengerDev.Challenger.Dev.entities.Client;
import com.example.challengerDev.Challenger.Dev.service.ClientService;
import com.sun.jdi.InvalidTypeException;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "API - Clientes")
@RequestMapping("/api/clientes")
public class ClientController {

    private final ClientService clienteService;

    @GetMapping
    public List<Client> listaClientes() {
        return clienteService.lista();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Client> buscaCliente(@PathVariable Long clienteId) {
        Client cliente = clienteService.busca(clienteId);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Client> insereCliente(@Valid @RequestBody Client cliente) throws InvalidTypeException {
        return clienteService.insere(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Client> atualizaCliente(@PathVariable Long clienteId, @RequestBody @Valid Client cliente) {
        return clienteService.atualiza(clienteId, cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> excluiCliente(@PathVariable Long clienteId) {
        return clienteService.exclui(clienteId);
    }
}
