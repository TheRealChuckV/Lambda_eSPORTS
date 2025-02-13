package com.example.demo.service;

import org.springframework.stereotype.Service;
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
}
