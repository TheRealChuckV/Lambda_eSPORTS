package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional; 

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByUsername(String username);
    List<Player> findByEmail(String email);

    Optional<Player> findByUsernameIgnoreCase(String username);
}