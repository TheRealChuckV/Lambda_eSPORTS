package com.example.demo.ctr;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final LoginService loginService = new LoginService();/*

    public LoginController(LoginController authService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        if (loginService.authenticate(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username); // Salva l'utente nella sessione
            return "Login effettuato con successo!";
        } else {
            return "Credenziali errate";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Distrugge la sessione
        }
        return "Logout effettuato";
    }*/
}
