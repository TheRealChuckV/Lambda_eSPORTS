package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    List<Player> findByUsername(String username);
    List<Player> findByEmail(String email);
}