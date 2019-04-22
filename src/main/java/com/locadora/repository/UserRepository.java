package com.locadora.repository;

import com.locadora.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
 
    @Query(value = "SELECT * FROM user WHERE email LIKE :email", nativeQuery = true)
    public User findByEmail(@Param("email") String email);
    
}