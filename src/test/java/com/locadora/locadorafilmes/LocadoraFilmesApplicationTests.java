package com.locadora.locadorafilmes;

import com.locadora.controller.FilmeController;
import com.locadora.controller.LocacaoController;
import com.locadora.controller.UsuarioController;
import com.locadora.model.Filme;
import com.locadora.model.Locacao;
import com.locadora.model.Usuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocadoraFilmesApplicationTests {
    
    @Autowired
    private UsuarioController uController;
    
    @Autowired
    private FilmeController fController;
    
    @Autowired
    private LocacaoController lController;

    @Test
    public void contextLoads() {
        // Filmes
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
        
        // Persist Filmes
        fController.addFilme(f1);
        fController.addFilme(f2);
        fController.addFilme(f3);
        fController.addFilme(f4);
        fController.addFilme(f5);
        fController.addFilme(f6);
        
        // Usuarios
        Usuario u1 = new Usuario();
        u1.setEmail("joao@xmail.com");
        u1.setNome("João da Silva");
        u1.setSenha("j0@0");
        
        Usuario u2 = new Usuario();
        u2.setEmail("manoel@pao.com");
        u2.setNome("Manoel da Padaria");
        u2.setSenha("paoquentinho");
        
        // Persist Usuarios
        uController.addUsuario(u1);
        uController.addUsuario(u2);
        
        // Locacoes
        SimpleDateFormat sdf = new SimpleDateFormat(Locacao.DATA_PATERN);
        Calendar c = Calendar.getInstance();
        String agora = sdf.format(c.getTime());
        c.add(Calendar.DATE, 7);
        String umaSemana = sdf.format(c.getTime());        
        
        Locacao l1 = new Locacao();
        l1.setDataDevolucao(null);
        l1.setDataLocacao(agora);
        l1.setFilme(f4);
        l1.setPrevisaoDevolucao(umaSemana);
        l1.setUsuario(u1);
        
        Locacao l2 = new Locacao();
        l2.setDataDevolucao(null);
        l2.setDataLocacao(agora);
        l2.setFilme(f2);
        l2.setPrevisaoDevolucao(umaSemana);
        l2.setUsuario(u2);
        
        // Persist Locacoes
        lController.addLocacao(l1);
        lController.addLocacao(l2);
        
        System.out.println("TEST");
        System.out.println(l1);
        System.out.println(l2);
    }

}

