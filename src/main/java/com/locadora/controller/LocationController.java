package com.locadora.controller;

import com.locadora.model.ErrorResponse;
import com.locadora.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.locadora.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("locations")
public class LocationController {
    
    @Autowired
    private LocationService service;

    @PostMapping("start")
    public @ResponseBody ResponseEntity startLocation(@RequestBody Location l) {
        try {
            
            Location loc = service.startLocation(l);
            return new ResponseEntity(HttpStatus.OK);
            
        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.LOCATION_START_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }
    }
    
    @PostMapping("finish")
    public @ResponseBody ResponseEntity finishLocation(@RequestBody Location l) {
        try {
            
            Location loc = service.finishLocation(l.getId());
            return new ResponseEntity(HttpStatus.OK);
            
        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.LOCATION_FINISH_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }        
    }
}