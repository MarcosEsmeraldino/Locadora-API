package com.locadora.service;

import com.locadora.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.locadora.repository.UserRepository;
import java.util.HashSet;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

//    @Autowired
//    private PasswordEncoder encoder;
    
    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User u) {
        
        // set encoded pass
//        String encodedPass = encoder.encode(u.getPass());
        String encodedPass = u.getPass();
        u.setPass(encodedPass);
        
        // save in db
        User save = repository.save(u);
        return save;
        
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException("");
        
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPass(), new HashSet<>());         
    }
    
}
