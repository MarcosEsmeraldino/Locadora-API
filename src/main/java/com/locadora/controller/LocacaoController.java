package com.locadora.controller;

import com.locadora.model.Filme;
import com.locadora.model.Locacao;
import com.locadora.model.Usuario;
import com.locadora.repository.LocacaoRepository;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("locations")
public class LocacaoController {
    // crud
    // locação de um filme
    // devolução de um filme
    
    @Autowired
    private LocacaoRepository repository;
    
    @GetMapping("/populate")
    public @ResponseBody Iterable<Locacao> populate() {
        
        Usuario u = new Usuario();
        u.setId(1);
        
        Filme f = new Filme();
        f.setId(1);
        
        Date hoje = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(hoje);
        c.add(Calendar.DATE, +7);
        Date previsao = c.getTime();
        
        Locacao l = new Locacao();
        l.setFilme(f);
        l.setUsuario(u);
        l.setDataLocacao(hoje);
        l.setPrevisaoDevolucao(previsao);
        
        repository.save(l);
        
        return repository.findAll();
    }
}
