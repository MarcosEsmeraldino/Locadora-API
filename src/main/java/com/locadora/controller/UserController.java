package com.locadora.controller;

import com.locadora.model.User;
import com.locadora.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("users")
public class UserController {
    
    @Autowired
    private UserService service;
    
    // temp
    @GetMapping
    public @ResponseBody List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("populate")
    public @ResponseBody List<User> populate() {
        
        User u1 = new User();
        u1.setEmail("marcos@gmail.com");
        u1.setName("Marcos");
        u1.setPass("123456789");
        
        service.save(u1);
        
        return findAll();
        
    }
    // END temp
    
    /*
    Create User
    POST /clients
    */
    @PostMapping("create")
    public @ResponseBody ResponseEntity addUsuario(@RequestBody User u) {
        
        try {
            
            User user = service.save(u);
            return new ResponseEntity(user, HttpStatus.OK);

        } catch(Exception ex) {
            
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
            
        }
        
    }
    
}