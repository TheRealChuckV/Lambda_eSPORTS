package com.example.demo.service;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import java.util.List;
import java.util.Optional;

@Service
@Transactional 
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> getPlayerById(int id) {
        return playerRepository.findById(id);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player getPlayerByUsername(String username) {
        return playerRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public Player getPlayerByEmail(String email) {
        return playerRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public Player updatePlayer(Player player) {
        Optional<Player> existingPlayerOptional = playerRepository.findById(player.getId());
        if (existingPlayerOptional.isPresent()) {
            Player existingPlayer = existingPlayerOptional.get();

            existingPlayer.setUsername(player.getUsername());
            existingPlayer.setEmail(player.getEmail());
            existingPlayer.setFirstName(player.getFirstName());
            existingPlayer.setLastName(player.getLastName());
            existingPlayer.setRole(player.getRole());
            existingPlayer.setDateOfBirth(player.getDateOfBirth());
            existingPlayer.setPassword(player.getPassword()); // Consider if you want to allow password updates here

            return playerRepository.save(existingPlayer);
        } else {
            return null;
        }
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return playerRepository.findByUsernameIgnoreCase(username).isEmpty();
    }
}