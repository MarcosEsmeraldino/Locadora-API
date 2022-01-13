package com.locadora.controller;

import com.locadora.model.Location;
import com.locadora.service.LocationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("locations")
public class LocationController {
    
    @Autowired
    private LocationService service;

    @PostMapping("start")
    @ApiOperation("Iniciar Locação")
    @ResponseStatus(HttpStatus.OK)
    public Location startLocation(@RequestBody Location l) {
        return service.startLocation(l);
    }
    
    @PostMapping("finish")
    @ApiOperation("Finalizar Locação")
    @ResponseStatus(HttpStatus.OK)
    public Location finishLocation(@RequestBody Location l) {
        return service.finishLocation(l.getId());
    }
}