package com.locadora.controller;

import com.locadora.model.Location;
import com.locadora.model.MovieLocation;
import com.locadora.model.User;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.locadora.repository.MovieRepository;
import com.locadora.repository.UserRepository;
import com.locadora.service.LocationService;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("locations")
public class LocationController {
    
    @Autowired
    private LocationService service;
    
    @Autowired
    private UserRepository uRepository;
    
    @Autowired
    private MovieRepository mRepository;
    
    // temp
    @GetMapping
    public @ResponseBody List<Location> findAll() {
        return service.findAll();
    }
    
    
    @GetMapping("populate")
    public @ResponseBody List<Location> populate() {
        
        // set user
        User u1 = uRepository.getOne((long) 1);
        
        
        // set movies
        MovieLocation m1 = new MovieLocation();
        m1.setMovie(mRepository.getOne((long) 3));
        m1.setQuant(1);
        
        MovieLocation m2 = new MovieLocation();
        m2.setMovie(mRepository.getOne((long) 4));
        m2.setQuant(2);
        
        List<MovieLocation> movies = new ArrayList();
        movies.add(m1);
        movies.add(m2);

        
        // set dates
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        String agora = sdf.format(c.getTime());
        c.add(Calendar.DATE, 7);
        String umaSemana = sdf.format(c.getTime());
        
        
        // set location
        Location l1 = new Location();
        l1.setExpectedDate(umaSemana);
        l1.setFinishDate(null);
        l1.setMovies(movies);
        l1.setStartDate(agora);
        l1.setUser(u1);
        
        // save
        service.startLocation(l1);
        
        return findAll();
        
    }
    // end temp
    
    /*
    Start Location
    POST /locations
    */
    @PostMapping("start")
    public @ResponseBody ResponseEntity startLocation(@RequestBody Location l) {
        try {
            
            Location loc = service.startLocation(l);
            return new ResponseEntity(loc, HttpStatus.OK);
            
        } catch(Exception ex) {
            
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
            
        }
    }
    
    /*
    Finish Location
    POST /locations
    */
    @GetMapping("finish/{id}")
    public @ResponseBody ResponseEntity finishLocation(@PathVariable("id") long id) {
        try {
            
            Location l = service.findById(id);
            Location loc = service.finishLocation(l);
            return new ResponseEntity(loc, HttpStatus.OK);
            
        } catch(Exception ex) {
            
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
            
        }        
    }
}