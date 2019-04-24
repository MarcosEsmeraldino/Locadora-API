package com.locadora.security;

import com.locadora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        // POST sem autenticacao
        web
            .ignoring().antMatchers(HttpMethod.POST, "/users/create").and()
            .ignoring().antMatchers(HttpMethod.POST, "/auth/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
                
            // resolve acessos POST com autenticacao
            .cors().and().csrf().disable()
                
            // GET sem autenticacao
            .authorizeRequests()
                .antMatchers(
                        "/movies/search/**",
                        "/auth/logout"
                ).permitAll()
                .anyRequest().authenticated();
    }
}