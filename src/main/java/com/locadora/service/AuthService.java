package com.locadora.service;

import com.locadora.model.User;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService uService;

    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired(required=true)
    private HttpServletRequest request;

    public User login(String email, String pass) {
                
        User user = uService.findByEmail(email);
        
        if (user == null) throw new UsernameNotFoundException(email);
        UsernamePasswordAuthenticationToken token = 
                new UsernamePasswordAuthenticationToken(email, pass, new HashSet<>());
        
        authManager.authenticate(token);
        
        if (token.isAuthenticated()) {
            
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(token);
            
            HttpSession session = request.getSession(true);
            session.setAttribute(HttpSessionSecurityContextRepository
                    .SPRING_SECURITY_CONTEXT_KEY, sc);

            return user;
        }
        
        return null;
        
    }
    
    public void logout() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if ((auth instanceof AnonymousAuthenticationToken)) {
            throw new UsernameNotFoundException("");
        }
        else {
        
            HttpSession session = request.getSession(true);

            session.invalidate();
            //session.removeAttribute(HttpSessionSecurityContextRepository
                    //.SPRING_SECURITY_CONTEXT_KEY);
        }
    }
}
