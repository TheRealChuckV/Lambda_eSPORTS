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
		if (path.equals("/") || path.equals("/home") || path.equals("/views/home.jsp")
				|| path.equals("/views/signup.jsp") || path.equals("/players/preSignup")
				|| path.equals("/players/signup") || path.startsWith("/auth/login") || path.startsWith("/auth/logout")
				|| path.startsWith("/resources/") || path.endsWith(".css") || path.endsWith(".js")
				|| path.endsWith(".jpg") || path.endsWith(".png")) {
			chain.doFilter(request, response);
			return;
		}

		HttpSession session = req.getSession(false); // Non crea una nuova sessione se non esiste
		if (session != null) {
			String user = (String) session.getAttribute("username");
			if (user != null && !user.isEmpty()) {
				chain.doFilter(request, response);
				return;
			} else {
				System.out.println("Sessione trovata ma utente non autenticato.");
			}
		} else {
			System.out.println("Nessuna sessione trovata.");
		}

		// Se la sessione è nulla o non contiene l'utente, blocca la richiesta
		res.sendRedirect(req.getContextPath() + "/auth/login");
	}

}
