package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TournamentPlayer {
	@Id
	private int id;
	//int playerId;
	@ManyToOne
    @JoinColumn(name = "player_id")
	private Player player;
	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;
	public TournamentPlayer(int id, Player player, Tournament tournament) {
		super();
		this.id = id;
		this.player = player;
		this.tournament = tournament;
	}
		
	public TournamentPlayer(Player player, Tournament tounrament) {
		super();
		this.player = player;
		this.tournament = tounrament;
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
}
