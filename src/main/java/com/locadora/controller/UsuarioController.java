package com.locadora.controller;

import com.locadora.model.Usuario;
import com.locadora.repository.UsuarioRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clients")
public class UsuarioController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository repository;
    
    // temp
    @GetMapping
    public @ResponseBody List<Usuario> listUsuarios() {
        return (List<Usuario>) repository.findAll();
    }
    // end temp
    
    /*
    Criar usuário
    POST /clients
    */
    @PostMapping
    public @ResponseBody ResponseEntity addUsuario(@RequestBody Usuario u) {
        
        try {
            
            Usuario un = repository.save(u);
            return new ResponseEntity(un, HttpStatus.CREATED);

        } catch(Exception ex) {
            
            /*
            Deve ser feito uma verificação do tipo da exceção para
            enviar uma mensagem adequada no ResponseEntity.
            */
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
            
        }
    }
    
    /*
    Fazer login de usuário
    POST /clients/login
    */
    @PostMapping("login")
    public @ResponseBody ResponseEntity login(@RequestBody Usuario uLogin) {
        
        try {
            
            String email = uLogin.getEmail();
            String senha = uLogin.getSenha();

            Usuario u = repository.findByEmail(email);

            // email não existe
            if(u == null)
                return new ResponseEntity("Usuário não encontrado.", HttpStatus.BAD_REQUEST);

            // sucesso
            if(u.getSenha().equals(senha)) {
                
                

                Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
                UserDetails userDetails = new User(email, senha, grantedAuthorities);
                UsernamePasswordAuthenticationToken token = 
                        new UsernamePasswordAuthenticationToken(userDetails, 
                                senha, userDetails.getAuthorities());

                authenticationManager.authenticate(token);

                if (token.isAuthenticated()) {
                    SecurityContextHolder.getContext().setAuthentication(token);
                    System.out.println(String.format("Auto login %s successfully!", email));
                }
                
                return new ResponseEntity(u, HttpStatus.ACCEPTED);
                
            }

            // senha incorreta
            else
                return new ResponseEntity("Senha incorreta.", HttpStatus.BAD_REQUEST);

        } catch (AuthenticationException ex) {

            return new ResponseEntity(ex, HttpStatus.BAD_REQUEST);
            
        }
    }

    /*
    Fazer logoff de usuário
    POST /clients/logoff
    */
}