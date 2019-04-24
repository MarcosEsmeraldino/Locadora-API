package com.locadora.controller;

import com.locadora.model.ErrorResponse;
import com.locadora.model.Movie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.locadora.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    private MovieService service;
    
    @GetMapping("/search/available")
    public @ResponseBody ResponseEntity searchAvailable() {
        
        try {
    
            List<Movie> list = service.searchAvailable();
            return new ResponseEntity(list, HttpStatus.OK);
        
        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.MOVIES_SEARCH_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }
    }
    
    @GetMapping("search/title/{title}")
    public @ResponseBody ResponseEntity searchByTitle(@PathVariable("title") String title) {
        try {
            
            List<Movie> list = service.searchByTitle(title);
            return new ResponseEntity(list, HttpStatus.OK);
        
        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.MOVIES_SEARCH_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }
    }
}
