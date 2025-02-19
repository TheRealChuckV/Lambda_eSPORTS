package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permette l'accesso a tutte le richieste
            )
            .csrf(csrf -> csrf.disable()) // Disabilita CSRF se non necessario
            .formLogin(login -> login.disable()) // Disabilita il form di login
            .httpBasic(basic -> basic.disable()); // Disabilita l'autenticazione di base

        return http.build();
    }
}