package com.locadora.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("health-check")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Informar saúde da API")
    public void testar() {}

}
