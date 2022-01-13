package com.locadora.controller;

import com.locadora.exception.BusinessException;
import com.locadora.model.Movie;
import com.locadora.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    private MovieService service;
    
    @GetMapping("/search/available")
    @ApiOperation("Buscar todos os filmes disponíveis para locação")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> searchAvailable() {
        return service.searchAvailable();
    }
    
    @GetMapping("search/title/{title}")
    @ApiOperation("Buscar Filmes, filtrando pelo título")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> searchByTitle(@PathVariable("title") String title) {
        return service.searchByTitle(title);
    }

    @GetMapping("/")
    @ApiOperation("Buscar todos os Filmes")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar Filme por ID")
    @ResponseStatus(HttpStatus.OK)
    public Movie findById(@PathVariable("id") String id) {
        long idLong = Long.parseLong(id);
        return service.findById(idLong).orElseThrow(() -> new BusinessException());
    }
}
