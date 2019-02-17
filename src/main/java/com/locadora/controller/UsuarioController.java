package com.locadora.controller;

import com.locadora.model.Usuario;
import com.locadora.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/clients")
public class UsuarioController {
    // crud
    // criação de usuários
    // logon e logoff de um usuário
    
    @Autowired
    private UsuarioRepository repository;
    
    // create
    @PostMapping("/add")
    public Usuario addUsuario(@RequestBody Usuario u) {
        return repository.save(u);
    }
    
    // read
    @GetMapping("/read")
    public Iterable<Usuario> listUsuarios() {
        return repository.findAll();
    }
}
