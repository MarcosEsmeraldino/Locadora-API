package com.locadora.service;

import com.locadora.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService uService;

    @Autowired
    private AuthenticationManager authManager;
    
    public User login(String email, String password) {
        
        User user = uService.findByEmail(email);
        
        if (user == null) throw new UsernameNotFoundException(email);
        UsernamePasswordAuthenticationToken token = 
                new UsernamePasswordAuthenticationToken(email, password);

        authManager.authenticate(token);

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            return user;
        }
        
        return null;
        
    }
    
    public void logout() {
        String logged = findLoggedInUsername();
    }

    public String findLoggedInUsername() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                
        System.out.println(auth.getName());
        System.out.println(auth.getPrincipal());
        System.out.println(auth.isAuthenticated());
        System.out.println(auth.getDetails());
        System.out.println(auth.getClass());
        
        Object userDetails = SecurityContextHolder.getContext()
                .getAuthentication().getDetails();
        
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }    
}
