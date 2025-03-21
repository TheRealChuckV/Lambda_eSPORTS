package com.example.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Player;
import com.example.demo.model.Tournament;

public interface TournamentService {

	public List<Tournament> getAllTournaments();

	public List<Tournament> getByGameId(int id);

	public List<Tournament> getByStartDate(Date date);

	public List<Tournament> getByNPlayer(int n);

	public void saveTournament(Tournament trmt);

	public Optional<Tournament> getUserById(int id);

	public void deleteTournament(int id);
	
	public boolean joinTournament(int id, Player player);
	
	public List<Tournament> getTournamentsByPlayer(Player player);
	
	public boolean leaveTournament(int tournamentId, Player player);
	
	public Optional<Tournament> getById(int id);
}
