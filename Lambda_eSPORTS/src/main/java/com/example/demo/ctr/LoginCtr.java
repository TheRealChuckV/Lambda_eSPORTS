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
		return "login";
	}

	@PostMapping("/login")
	public void login(@RequestParam String loginString, @RequestParam String password, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println(loginString);
		HttpSession session = request.getSession(false); // Non crea una nuova sessione se non esiste
		if (session != null && (session.getAttribute("username") != null)) {
			response.sendRedirect(request.getContextPath() + "/views/home.jsp");// Se già autenticato, redirect alla home
		} else if (loginService.authenticate(loginString, password)) {
			session = request.getSession(true); // Crea una nuova sessione se non esiste
			if(loginString.contains("@")) session.setAttribute("email", loginString);
			else session.setAttribute("username", loginString);
			response.sendRedirect(request.getContextPath() + "/views/home.jsp"); // Reindirizza alla dashboard
		} else {
			response.sendRedirect(request.getContextPath() + "/auth/login?error=true"); // Reindirizza alla login con
																						// errore
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
