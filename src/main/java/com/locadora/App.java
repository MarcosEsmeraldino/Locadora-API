package com.locadora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    
    // O sistema deve permitir:
    // criação de usuários
    // logon e logoff de um usuário
    // listagem de filmes disponíveis
    // locação de um filme
    // devolução de um filme
    // pesquisa de filme pelo título
}
