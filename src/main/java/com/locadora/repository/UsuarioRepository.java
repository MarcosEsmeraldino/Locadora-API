package com.locadora.repository;

import com.locadora.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
 
    @Query(value = "SELECT * FROM usuario WHERE email LIKE :email", nativeQuery = true)
    public Usuario findByEmail(@Param("email") String email);
    
}