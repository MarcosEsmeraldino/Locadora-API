package com.locadora.service;

import com.locadora.model.Movie;
import com.locadora.repository.MovieRepository;
import java.text.Normalizer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository repository;
    
    public List<Movie> findAll() {
        return repository.findAll();
    }
    
    public Movie save(Movie m) {
        return repository.save(m);
    }
    
    public List<Movie> searchAvailable() {
        return repository.searchAvailable();
    }
    
    public List<Movie> searchByTitle(String title) {

        // prepare title do search
        String normalizeTitle = Normalizer.normalize(title, Normalizer.Form.NFD)
           .replaceAll("[^\\p{ASCII}]", "");
        String lowerTitle = normalizeTitle.toLowerCase();
        
        return repository.searchByTitle(lowerTitle);
        
    }
}
