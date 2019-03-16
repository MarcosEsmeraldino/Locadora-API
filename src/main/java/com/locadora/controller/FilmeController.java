package com.locadora.controller;

import com.locadora.model.Filme;
import com.locadora.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("movies")
public class FilmeController {
    
    @Autowired
    private FilmeRepository repository;
    
    // temp
    @GetMapping
    public @ResponseBody List<Filme> listFilmes() {
        return repository.findAll();
    }
    
    @GetMapping("populate")
    public @ResponseBody List<Filme> populate() {
        Filme f1 = new Filme();
        f1.setCopias(0);
        f1.setDiretor("Peter Jackson");
        f1.setTitulo("O Senhor dos Anéis - A Sociedade do Anel");
        
        Filme f2 = new Filme();
        f2.setCopias(0);
        f2.setDiretor("Peter Jackson");
        f2.setTitulo("O Senhor dos Anéis - As Duas Torres");
        
        Filme f3 = new Filme();
        f3.setCopias(2);
        f3.setDiretor("Peter Jackson");
        f3.setTitulo("O Senhor dos Anéis - O Retorno do Rei");
        
        Filme f4 = new Filme();
        f4.setCopias(2);
        f4.setDiretor("Peter Jackson");
        f4.setTitulo("O Hobbit: Uma Jornada Inesperada");
        
        Filme f5 = new Filme();
        f5.setCopias(4);
        f5.setDiretor("Peter Jackson");
        f5.setTitulo("O Hobbit: A Desolação de Smaug");
        
        Filme f6 = new Filme();
        f6.setCopias(4);
        f6.setDiretor("Peter Jackson");
        f6.setTitulo("O Hobbit: A Batalha dos Cinco Exércitos");

        repository.save(f1);
        repository.save(f2);
        repository.save(f3);
        repository.save(f4);
        repository.save(f5);
        repository.save(f6);
        
        return listFilmes();
    }
    // end test
    
    @PostMapping
    public @ResponseBody Filme addFilme(@RequestBody Filme filme) {
        return repository.save(filme);
    }
    
    /*
    Listar filmes disponíveis
    GET /movies/available
    */
    @GetMapping("available")
    public @ResponseBody List<Filme> listDisponiveis() {
        return repository.listDisponiveis();
    }
    
    /*
    Pesquisar filmes por título
    GET /movies/search/titulo_a_ser_buscado
    */
    @GetMapping("search/{title}")
    public @ResponseBody List<Filme> listPorTitulo(@PathVariable("title") String titulo) {
        return repository.listByTitulo(titulo);
    }
}
