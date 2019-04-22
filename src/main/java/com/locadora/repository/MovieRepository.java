package com.locadora.repository;

import com.locadora.model.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie WHERE stock > 0", nativeQuery = true)
    public List<Movie> searchAvailable();
    
    @Query(value = "SELECT * FROM movie WHERE LOWER(title) LIKE %:t%", nativeQuery = true)
    public List<Movie> searchByTitle(@Param("t") String title);
    
}
