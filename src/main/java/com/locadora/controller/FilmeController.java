package com.locadora.controller;

import com.locadora.model.Filme;
import com.locadora.repository.FilmeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/movies")
public class FilmeController {
    // crud
    // pesquisa de filme pelo título
    
    @Autowired
    private FilmeRepository repository;
    
    @GetMapping("/all")
    public @ResponseBody Iterable<Filme> listAll() {
        return repository.findAll();
    }
    
    @GetMapping("/")
    public @ResponseBody Optional<Filme> find(@RequestParam long id) {
        return repository.findById(id);
    }
}
