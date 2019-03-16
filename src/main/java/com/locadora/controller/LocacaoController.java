package com.locadora.controller;

import com.locadora.model.Filme;
import com.locadora.model.Locacao;
import com.locadora.model.Usuario;
import com.locadora.repository.LocacaoRepository;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("locations")
public class LocacaoController {
    
    @Autowired
    private LocacaoRepository repository;
    
    // temp
    @GetMapping
    public @ResponseBody List<Locacao> listLocacoes() {
        return (List<Locacao>) repository.findAll();
    }
    
    @GetMapping("populate")
    public void populate() {
        UsuarioController uController = new UsuarioController();
        System.out.println(uController);
        
        /*
        UsuarioController uController = new UsuarioController();
        List<Usuario> listUsuarios = (List<Usuario>) uController.listUsuarios();
        Usuario u1 = listUsuarios.get(0);
        Usuario u2 = listUsuarios.get(1);
        
        FilmeController fController = new FilmeController();
        List<Filme> listFilmes = fController.listPorTitulo("");
        Filme f1 = listFilmes.get(0);
        Filme f2 = listFilmes.get(1);
        
        SimpleDateFormat sdf = new SimpleDateFormat(Locacao.DATA_PATERN);
        Calendar c = Calendar.getInstance();
        String agora = sdf.format(c.getTime());
        c.add(Calendar.DATE, 7);
        String umaSemana = sdf.format(c.getTime());        
        
        Locacao l1 = new Locacao();
        l1.setDataDevolucao(null);
        l1.setDataLocacao(agora);
        l1.setFilme(f1);
        l1.setPrevisaoDevolucao(umaSemana);
        l1.setUsuario(u1);
        
        Locacao l2 = new Locacao();
        l2.setDataDevolucao(null);
        l2.setDataLocacao(agora);
        l2.setFilme(f2);
        l2.setPrevisaoDevolucao(umaSemana);
        l2.setUsuario(u2);*/
    }
    // end temp
    
    /*
    locação de um filme
    POST /locations
    */
    @PostMapping("locations")
    public void addLocacao(@RequestBody Locacao l) {
        repository.save(l);
    }
    
    /*
    devolução de um filme
    PUT /locations
    */
    @PutMapping("locations")
    public void addDevolucao(@RequestBody Locacao l) {
        repository.save(l);
    }
}