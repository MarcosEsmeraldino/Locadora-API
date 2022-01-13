package com.locadora.controller;

import com.locadora.model.User;
import com.locadora.service.AuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService aService;
       
    @PostMapping("login")
    @ApiOperation("Realizar login do Usuário")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestBody User u) {
        return aService.login(u.getEmail(), u.getPass());
    }

    @GetMapping("logout")
    @ApiOperation("Realizar logout do Usuário")
    @ResponseStatus(HttpStatus.OK)
    public void logout() {
        aService.logout();
    }
}
