package com.locadora.controller;

import com.locadora.model.ErrorResponse;
import com.locadora.model.Location;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.locadora.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locations")
public class LocationController {
    
    @Autowired
    private LocationService service;

    @PostMapping("start")
    @ApiOperation("Iniciar Locação")
    public ResponseEntity startLocation(@RequestBody Location l) {
        try {
            
            Location loc = service.startLocation(l);
            return new ResponseEntity(HttpStatus.OK);
            
        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.LOCATION_START_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }
    }
    
    @PostMapping("finish")
    @ApiOperation("Finalizar Locação")
    public ResponseEntity finishLocation(@RequestBody Location l) {
        try {
            
            Location loc = service.finishLocation(l.getId());
            return new ResponseEntity(HttpStatus.OK);
            
        } catch(Exception ex) {
            
            return new ResponseEntity(ErrorResponse.LOCATION_FINISH_ERROR, 
                    HttpStatus.BAD_REQUEST);
            
        }        
    }
}