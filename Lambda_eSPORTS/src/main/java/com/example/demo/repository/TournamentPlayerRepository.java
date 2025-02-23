package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Player;
import com.example.demo.model.TournamentPlayer;

public interface TournamentPlayerRepository extends JpaRepository<TournamentPlayer, Integer>{
	// Trova tutti i tornei a cui un player è iscritto
    List<TournamentPlayer> findByPlayer(Player player);
}
