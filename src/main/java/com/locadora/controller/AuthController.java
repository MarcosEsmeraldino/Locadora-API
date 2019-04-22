package com.locadora.controller;

import com.locadora.model.User;
import com.locadora.service.AuthService;
import com.locadora.service.UserService;
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
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UserService uService;

    @Autowired
    private AuthService aService;
       
    /*
    Login User
    POST /auth/login
    */
    @PostMapping("login")
    public @ResponseBody ResponseEntity login(@RequestBody User u) {
        
        try {

            aService.login(u.getEmail(), u.getPass());
            
            User loggin = uService.findByEmail(u.getEmail());
            return new ResponseEntity(loggin, HttpStatus.OK);
            
        } catch (UsernameNotFoundException unfe) {
            
            return new ResponseEntity("Usuário não encontrado.", HttpStatus.UNAUTHORIZED);

        } catch (AuthenticationException ae) {

            return new ResponseEntity("Senha incorreta.", HttpStatus.UNAUTHORIZED);
            
        }
    }

    /*
    Logout User
    GET /auth/logout
    */    
    @GetMapping("logout")
    public @ResponseBody void logout() {
        aService.logout();
    }

}
