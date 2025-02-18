package com.example.demo.ctr;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/session")
public class SessionCtr {

    @GetMapping("/set")
    public String setSession(HttpSession session) {
        session.setAttribute("username", "utente_test");
        return "Sessione creata con username: utente_test";
    }

    @GetMapping("/get")
    public String getSession(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return username != null ? "Username in sessione: " + username : "Nessuna sessione trovata!";
    }

    @GetMapping("/invalidate")
    public String invalidateSession(HttpSession session) {
        session.invalidate();
        return "Sessione invalidata!";
    }
}
