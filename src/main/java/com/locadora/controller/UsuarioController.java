package com.locadora.controller;

import com.locadora.model.Usuario;
import com.locadora.repository.UsuarioRepository;
import com.locadora.service.SecurityService;
import com.locadora.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private UsuarioService uService;

    @Autowired
    private SecurityService sService;
    
    @Autowired
    private UsuarioRepository uRepository;
    
    // temp
    @GetMapping
    public @ResponseBody List<Usuario> listUsuarios() {
        return (List<Usuario>) uRepository.findAll();
    }
    // end temp
    
    /*
    Criar usuário
    POST /clients
    */
    @PostMapping
    public @ResponseBody ResponseEntity addUsuario(@RequestBody Usuario u) {
        
        try {
            
            Usuario un = uService.save(u);
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
    public @ResponseBody ResponseEntity loginTest(@RequestBody Usuario u) {
        
        try {
                       
            sService.autoLogin(u.getEmail(), u.getSenha());
            
            Usuario loggin = uService.findByUsername(u.getEmail());
            return new ResponseEntity(loggin, HttpStatus.ACCEPTED);
            
        } catch (UsernameNotFoundException unfe) {
            
            return new ResponseEntity("Usuário não encontrado.", HttpStatus.BAD_REQUEST);

        } catch (AuthenticationException ae) {

            return new ResponseEntity("Senha incorreta.", HttpStatus.BAD_REQUEST);
            
        }
    }

    /*
    Fazer logoff de usuário
    POST /clients/logoff
    */
}