package com.example.demo.service;

import com.example.demo.model.Player;
import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> getAllPlayers();

    Optional<Player> getPlayerById(int id);

    Player savePlayer(Player player);

    void deletePlayer(int id);

    Player getPlayerByUsername(String username);

    Player getPlayerByEmail(String email);

    Player updatePlayer(Player player);

    
    boolean isUsernameUnique(String username);
}