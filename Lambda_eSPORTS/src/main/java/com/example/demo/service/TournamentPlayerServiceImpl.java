package com.example.demo.service;

import com.example.demo.model.TournamentPlayer;

public class TournamentPlayerServiceImpl implements TournamentPlayerService{

	@Override
	public void deleteFromTournament(int playerId, int trnmntId) {
		TournamentPlayer tournamentPlayer = new TournamentPlayer(playerId, trnmntId);
		
	}

	@Override
	public TournamentPlayer addToTournament(int playerId, int trnmntId) {
		
		return null;
	}

}
