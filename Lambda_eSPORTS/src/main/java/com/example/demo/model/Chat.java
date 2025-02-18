package com.example.demo.model;


public class Chat {
	private int idChat;
	private String message;
	private Tournament tournament;
	private Player player;

	

	public Chat(int idChat, String message, Tournament tournament, Player player) {
		super();
		this.idChat = idChat;
		this.message = message;
		this.tournament = tournament;
		this.player = player;
	}

	public Chat() {
		super();
	}

	public int getIdChat() {
		return idChat;
	}

	public void setIdChat(int idChat) {
		this.idChat = idChat;
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
		return "Chat [idChat=" + idChat + ", tournament=" + tournament + ", player=" + player + "]";
	}

}
