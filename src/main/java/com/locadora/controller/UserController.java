package com.locadora.controller;

import com.locadora.model.User;
import com.locadora.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
        
    @Autowired
    private UserService service;
    
    @PostMapping
    @Operation(summary = "Criar Usuário")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUsuario(@RequestBody User u) {
        return service.save(u);
    }
}