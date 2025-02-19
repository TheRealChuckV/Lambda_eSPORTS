package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Chat {
	@Id
	private int id;
	private String message;
	
	
	@ManyToOne
	private Tournament tournament;
	
	
	@ManyToOne
	private Player player;

	

	public Chat(int id, String message, Tournament tournament, Player player) {
		super();
		this.id = id;
		this.message = message;
		this.tournament = tournament;
		this.player = player;
	}

	public Chat() {
		super();
	}

	public int getIdChat() {
		return id;
	}

	public void setIdChat(int idChat) {
		this.id = idChat;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Chat [idChat=" + id + ", tournament=" + tournament + ", player=" + player + "]";
	}

}
