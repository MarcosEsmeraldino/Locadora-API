package com.locadora.controller;

import com.locadora.model.ErrorResponse;
import com.locadora.model.User;
import com.locadora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("users")
public class UserController {
        
    @Autowired
    private UserService service;
    
    @PostMapping("create")
    public @ResponseBody ResponseEntity addUsuario(@RequestBody User u) {
        
        try {
            
            User user = service.save(u);
            return new ResponseEntity(user, HttpStatus.CREATED);

        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.USER_CREATE_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }
        
    }
    
}