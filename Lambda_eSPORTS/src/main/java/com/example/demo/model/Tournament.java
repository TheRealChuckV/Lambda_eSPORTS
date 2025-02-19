package com.example.demo.model;

import java.sql.Date;
import java.util.List;
import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Tournament {
	@Id
	int id;
	String name;
	Date startDate;
	Date endDate;
	int nPlayer;
	String description;
	String prize;
	@ManyToOne
	@JoinColumn(name="game_id")
	Game game;
	@ManyToOne
	@JoinColumn(name="creator_id")
	Player creator;
	@OneToMany(mappedBy="tournament")
	private List<TournamentPlayer> tournamentPlayers;
	@OneToMany
	@JoinColumn(name="id_chat")
	private List<Chat> message;
	@OneToMany(mappedBy="tournament")
	private List<Matches> matches;
	
	public Tournament(String name, Date startDate, Date endDate, int nPlayer, String description, String prize,
			Game game, Player creator) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nPlayer = nPlayer;
		this.description = description;
		this.prize = prize;
		this.game = game;
		this.creator = creator;
	}
	
	public Tournament(int id, String name, Date startDate, Date endDate, int nPlayer, String description, String prize,
			Game game, Player creator) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nPlayer = nPlayer;
		this.description = description;
		this.prize = prize;
		this.game = game;
		this.creator = creator;
	}


	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getnPlayer() {
		return nPlayer;
	}
	public void setnPlayer(int nPlayer) {
		this.nPlayer = nPlayer;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Player getCreator() {
		return creator;
	}
	public void setCreator(Player creator) {
		this.creator = creator;
	}
	
	public List<TournamentPlayer> getTournamentplayers() {
		return tournamentPlayers;
	}

	public void setTournamentplayers(List<TournamentPlayer> tournamentPlayers) {
	this.tournamentPlayers = tournamentPlayers;
	}
	public List<Matches> getMatches() {
		return matches;
	}

	public void setMatches(List<Matches> matches) {
		this.matches = matches;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creator, description, endDate, game, id, nPlayer, name, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tournament other = (Tournament) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", nPlayer=" + nPlayer + ", description=" + description + ", gameId=" + game + ", creatorId="
				+ creator + "]";
	}
	
	
}