package com.locadora.controller;

import com.locadora.model.Usuario;
import com.locadora.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("clients")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    
    // temp
    @GetMapping
    public @ResponseBody List<Usuario> listUsuarios() {
        return (List<Usuario>) repository.findAll();
    }
    
    @GetMapping("populate")
    public @ResponseBody List<Usuario> populate() {
        Usuario u1 = new Usuario();
        u1.setEmail("joao@xmail.com");
        u1.setNome("João da Silva");
        u1.setSenha("j0@0");
        
        Usuario u2 = new Usuario();
        u2.setEmail("manoel@pao.com");
        u2.setNome("Manoel da Padaria");
        u2.setSenha("paoquentinho");
        
        repository.save(u1);
        repository.save(u2);
        
        return listUsuarios();
    }
    // end temp
    
    /*
    Criar usuário
    POST /clients
    */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addUsuario(@RequestBody Usuario u) {
        repository.save(u);
    }
    
    /*
    Fazer login de usuário
    POST /clients/login
    */
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("login")
    public void login(@RequestBody UsuarioLogin uLogin) {
        String email = uLogin.getEmail();
        String senha = uLogin.getSenha();
        
        Usuario u = repository.findByEmail(email);
        
        if(u == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        
        if(u.getSenha().equals(senha)) {
            System.out.println("Usuário encontrado: " + u);
        }
        else {
            System.out.println("Senha incorreta.");
        }
    }
    
    /*
    Fazer logoff de usuário
    POST /clients/logoff
    */
}

class UsuarioLogin {
    private String email;
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
