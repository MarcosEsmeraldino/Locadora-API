package com.locadora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HealthCheckController {

    @GetMapping("health-check")
    @ResponseStatus(HttpStatus.OK)
    public void testar() {}

}
