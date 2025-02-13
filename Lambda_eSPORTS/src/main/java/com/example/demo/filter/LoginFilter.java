package com.example.demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String path = req.getRequestURI();

        // Permetti il login e il logout senza autenticazione
        if (path.startsWith("/auth/login") || path.startsWith("/auth/logout")) {
            chain.doFilter(request, response);
            return;
        }

        // Controlla se l'utente è autenticato
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Accesso negato, fai il login.");
            return;
        }

        // Se l'utente è autenticato, continua con la richiesta
        chain.doFilter(request, response);
    }
}

