package com.locadora.repository;

import com.locadora.model.MovieLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieLocationRepository extends JpaRepository<MovieLocation, Long> {
    
}
