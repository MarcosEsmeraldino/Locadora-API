package com.locadora.controller;

import com.locadora.model.ErrorResponse;
import com.locadora.model.User;
import com.locadora.service.AuthService;
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
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService aService;
       
    @PostMapping("login")
    public @ResponseBody ResponseEntity login(@RequestBody User u) {
        
        try {

            User login = aService.login(u.getEmail(), u.getPass());
            return new ResponseEntity(login, HttpStatus.OK);
            
        } catch (Exception ex) {
            
            return new ResponseEntity(ErrorResponse.AUTH_LOGIN_ERROR, 
                    HttpStatus.UNAUTHORIZED);
            
        }

    }

    @GetMapping("logout")
    public @ResponseBody ResponseEntity logout() {
        
        try {

            aService.logout();
            return new ResponseEntity(HttpStatus.OK);
            
        } catch (Exception ex) {
            
            return new ResponseEntity(ErrorResponse.AUTH_LOGOUT_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }

    }

}
