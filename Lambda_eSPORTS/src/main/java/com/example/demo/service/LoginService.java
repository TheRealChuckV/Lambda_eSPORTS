package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginService {
   /* private final PlayerRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        Optional<Player> user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }*/
	 // Simuliamo un database in memoria con una mappa (username -> password)
    private final Map<String, String> users = new HashMap<>();

    public LoginService() {
        // Aggiungiamo utenti di test
        users.put("mario", "password123");
        users.put("luigi", "supersecret");
    }

    public boolean authenticate(String username, String password) {
    	System.out.println(username +"   " + password);
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
