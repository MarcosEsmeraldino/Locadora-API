package com.locadora.controller;

import com.locadora.model.Movie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.locadora.service.MovieService;

@Controller
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    private MovieService service;
    
    // temp
    @GetMapping
    public @ResponseBody List<Movie> findAll() {
        return service.findAll();
    }
    
    @GetMapping("populate")
    public @ResponseBody List<Movie> populate() {
        Movie f1 = new Movie();
        f1.setStock(0);
        f1.setDirector("Peter Jackson");
        f1.setTitle("O Senhor dos Anéis - A Sociedade do Anel");
        
        Movie f2 = new Movie();
        f2.setStock(0);
        f2.setDirector("Peter Jackson");
        f2.setTitle("O Senhor dos Anéis - As Duas Torres");
        
        Movie f3 = new Movie();
        f3.setStock(2);
        f3.setDirector("Peter Jackson");
        f3.setTitle("O Senhor dos Anéis - O Retorno do Rei");
        
        Movie f4 = new Movie();
        f4.setStock(2);
        f4.setDirector("Peter Jackson");
        f4.setTitle("O Hobbit: Uma Jornada Inesperada");
        
        Movie f5 = new Movie();
        f5.setStock(4);
        f5.setDirector("Peter Jackson");
        f5.setTitle("O Hobbit: A Desolação de Smaug");
        
        Movie f6 = new Movie();
        f6.setStock(4);
        f6.setDirector("Peter Jackson");
        f6.setTitle("O Hobbit: A Batalha dos Cinco Exércitos");

        service.save(f1);
        service.save(f2);
        service.save(f3);
        service.save(f4);
        service.save(f5);
        service.save(f6);
        
        return findAll();
    }
    // end test
    
    /*
    Search Available Movies
    GET /movies/search/available
    */
    @GetMapping("/search/available")
    public @ResponseBody List<Movie> searchAvailable() {
        return service.searchAvailable();
    }
    
    /*
    Search Movies by title
    GET /movies/search/title/{title_to_search}
    */
    @GetMapping("search/title/{title}")
    public @ResponseBody List<Movie> searchByTitle(@PathVariable("title") String title) {
        return service.searchByTitle(title);
    }
}
