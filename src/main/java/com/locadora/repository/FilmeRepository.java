package com.locadora.repository;

import com.locadora.model.Filme;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    @Query(value = "SELECT * FROM filme WHERE copias > 0", nativeQuery = true)
    public List<Filme> listDisponiveis();
    
    @Query(value = "SELECT * FROM filme WHERE titulo LIKE %:t%", nativeQuery = true)
    public List<Filme> listByTitulo(@Param("t") String titulo);
    
}
