package com.example.demo.ctr;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.LoginService;

@Controller
@RequestMapping("/auth")
public class LoginCtr {

    private final LoginService loginService;

    public LoginCtr(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @GetMapping("/login")
    public String showLoginPage() {
    	System.out.println("prova");
        return "login"; 
    }

    @PostMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password, 
                      HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (loginService.authenticate(username, password)) {
            HttpSession session = request.getSession(true); // Crea una nuova sessione se non esiste
            session.setAttribute("user", username);

            System.out.println("Login effettuato con successo per: " + username);
            response.sendRedirect(request.getContextPath() + "/dashboard"); // Reindirizza alla dashboard
        } else {
            System.out.println("Login fallito per: " + username);
            response.sendRedirect(request.getContextPath() + "/auth/login?error=true"); // Reindirizza alla login con errore
        }
    }


    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Distrugge la sessione
        }
        return "Logout effettuato";
    }
}
