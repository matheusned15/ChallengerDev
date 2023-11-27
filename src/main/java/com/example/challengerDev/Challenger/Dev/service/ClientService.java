package com.example.challengerDev.Challenger.Dev.service;

import com.example.challengerDev.Challenger.Dev.config.MessageConfig;
import com.example.challengerDev.Challenger.Dev.entities.Client;
import com.example.challengerDev.Challenger.Dev.exception.ClienteNotFoundException;
import com.example.challengerDev.Challenger.Dev.repository.ClientRepository;
import com.sun.jdi.InvalidTypeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final MessageConfig message;
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Client> lista() {
        return clientRepository.findAll();
    }

    public Client busca(Long clienteId) {
        return clientRepository.findById(clienteId).orElseThrow(() -> new ClienteNotFoundException(message.getMessage001()));
    }

    @Transactional
    public ResponseEntity<Client> insere(Client cliente) throws InvalidTypeException {
        if (nonNull(cliente.getId())) {
            throw new InvalidTypeException(message.getMessage002());
        }
        setCliente(cliente);
        clientRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    public ResponseEntity<Client> atualiza(Long clienteId, Client cliente) {
        busca(clienteId);
        setCliente(cliente);
        cliente = clientRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @Transactional
    public ResponseEntity<Void> exclui(Long clienteId) {
        busca(clienteId);
        clientRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }

    private void setCliente(Client cliente) {
        cliente.getEmails().forEach(item -> item.setClient(cliente));
        cliente.getPhones().forEach(item -> item.setClient(cliente));
    }
}
