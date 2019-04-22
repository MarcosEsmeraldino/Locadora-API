package com.locadora.service;

import com.locadora.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.locadora.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;
    
    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User u) {
        
        // set encoded pass
        String encodedPass = encoder.encode(u.getPass());
        u.setPass(encodedPass);
        
        // save in db
        User save = repository.save(u);
        return save;
        
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
    
}
