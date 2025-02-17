package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TournamentPlayer {
	@Id
	int id;
	int playerId;
	int tounramentId;
	public TournamentPlayer(int id, int playerId, int tounramentId) {
		super();
		this.id = id;
		this.playerId = playerId;
		this.tounramentId = tounramentId;
	}
		
	public TournamentPlayer(int playerId, int tounramentId) {
		super();
		this.playerId = playerId;
		this.tounramentId = tounramentId;
	}

	public TournamentPlayer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getTounramentId() {
		return tounramentId;
	}

	public void setTounramentId(int tounramentId) {
		this.tounramentId = tounramentId;
	}
	
}
