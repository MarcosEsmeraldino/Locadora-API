package com.locadora.controller;

import com.locadora.model.Location;
import com.locadora.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("locations")
public class LocationController {
    
    @Autowired
    private LocationService service;

    @PostMapping("start")
    @Operation(summary = "Iniciar Locação")
    @ResponseStatus(HttpStatus.OK)
    public Location startLocation(@RequestBody Location l) {
        return service.startLocation(l);
    }
    
    @PostMapping("finish")
    @Operation(summary = "Finalizar Locação")
    @ResponseStatus(HttpStatus.OK)
    public Location finishLocation(@RequestBody Location l) {
        return service.finishLocation(l.getId());
    }
}