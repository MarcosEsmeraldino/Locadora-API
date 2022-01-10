package com.locadora.controller;

import com.locadora.model.ErrorResponse;
import com.locadora.model.Movie;
import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.locadora.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    private MovieService service;
    
    @GetMapping("/search/available")
    @ApiOperation("Buscar todos os filmes disponíveis para locação")
    public ResponseEntity searchAvailable() {
        
        try {
    
            List<Movie> list = service.searchAvailable();
            return new ResponseEntity(list, HttpStatus.OK);
        
        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.MOVIES_SEARCH_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }
    }
    
    @GetMapping("search/title/{title}")
    @ApiOperation("Buscar Filmes, filtrando pelo título")
    public ResponseEntity searchByTitle(@PathVariable("title") String title) {
        try {
            
            List<Movie> list = service.searchByTitle(title);
            return new ResponseEntity(list, HttpStatus.OK);
        
        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.MOVIES_SEARCH_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }
    }

    @GetMapping("/")
    @ApiOperation("Buscar todos os Filmes")
    public ResponseEntity findAll() {

        try {

            List<Movie> list = service.findAll();
            return new ResponseEntity(list, HttpStatus.OK);

        } catch(Exception ex) {

            return new ResponseEntity(ErrorResponse.MOVIES_SEARCH_ERROR,
                    HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar Filme por ID")
    public ResponseEntity findById(@PathVariable("id") String id) {
        try {

            long idLong = Long.parseLong(id);
            Movie movie = service.findById(idLong)
                    .orElseThrow(() -> new RuntimeException());
            return new ResponseEntity(movie, HttpStatus.OK);

        } catch(Exception ex) {

            return new ResponseEntity(ErrorResponse.MOVIES_SEARCH_ERROR,
                    HttpStatus.BAD_REQUEST);

        }
    }
}
