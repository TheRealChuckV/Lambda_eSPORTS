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
		System.out.println("Richiesta ricevuta per: " + path);

		// Permetti il login e il logout senza autenticazione
		if (path.equals("/") || 
	            path.equals("/home") || 
	            path.equals("/views/home.jsp") || 
	            path.equals("/views/signup.jsp") || 
	            path.equals("/players/preSignup") ||
	            path.equals("/players/signup") || 
	            path.startsWith("/auth/login") || 
	            path.startsWith("/auth/logout") ||
	            path.startsWith("/resources/") || 
	            path.endsWith(".css") || 
	            path.endsWith(".js") || 
	            path.endsWith(".jpg") || 
	            path.endsWith(".png"))   {
			chain.doFilter(request, response);
			return;
		}

		// Controlla la sessione
		HttpSession session = req.getSession(false);
		System.out.println("Sessione trovata: " + (session != null));

		if (session != null) {
			System.out.println("User nella sessione: " + session.getAttribute("user"));
		}

		// Se la sessione è nulla o non contiene l'utente, blocca la richiesta
		if (session == null || session.getAttribute("user") == null) {
			res.sendRedirect(req.getContextPath() + "/auth/login");
			return;

		}

		// Se l'utente è autenticato, continua con la richiesta
		chain.doFilter(request, response);
	}

}
