package com.locadora.service;

import com.locadora.model.Usuario;
import com.locadora.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario save(Usuario u) {
        u.setSenha(encoder.encode(u.getSenha()));
        return repository.save(u);
    }

    public Usuario findByUsername(String email) {
        return repository.findByEmail(email);
    }
    
    public Usuario loggin(String email, String senha) {
        Usuario u = findByUsername(email);
        if (u == null) throw new UsernameNotFoundException(email);
        
        String senhaU = u.getSenha();
        String senhaEncode = encoder.encode(senha);
        
        System.out.println(senhaU);
        System.out.println(senhaEncode);
        System.out.println(senha);
        
        if(senhaU.equals(senhaU))
        //if(senhaU.equals(senha))
        //if(senhaU.equals(senhaEncode))
            return u;
        else
            throw new AuthenticationException("Senha incorreta") {};
    }
}
