package com.example.challengerDev.Challenger.Dev.repository;

import com.example.challengerDev.Challenger.Dev.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByLogin(String login);
}
