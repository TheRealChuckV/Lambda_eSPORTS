package com.example.demo.service;

import com.example.demo.model.TournamentPlayer;

public interface TournamentPlayerService{
	void deleteFromTournament(int playerId, int trnmntId);
	TournamentPlayer addToTournament(int playerId, int trnmntId);
	

}
