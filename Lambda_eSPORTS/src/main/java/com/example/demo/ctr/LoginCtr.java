package com.example.demo.ctr;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/auth")
public class LoginCtr {

    private final LoginService loginService;

    public LoginCtr(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        if (loginService.authenticate(username, password)) {
            HttpSession session = request.getSession(true); // Crea una nuova sessione se non esiste
            session.setAttribute("user", username);

            System.out.println("Login effettuato. Session ID: " + session.getId());
            System.out.println("User salvato nella sessione: " + session.getAttribute("user"));

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
    }
}
