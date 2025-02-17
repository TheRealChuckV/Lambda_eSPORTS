package com.example.demo.model;

import java.sql.Date;
import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
	int gameId;
	int creatorId;
	public Tournament(String name, Date startDate, Date endDate, int nPlayer, String description, String prize,
			int gameId, int creatorId) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nPlayer = nPlayer;
		this.description = description;
		this.prize = prize;
		this.gameId = gameId;
		this.creatorId = creatorId;
	}
	
	public Tournament(int id, String name, Date startDate, Date endDate, int nPlayer, String description, String prize,
			int gameId, int creatorId) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.nPlayer = nPlayer;
		this.description = description;
		this.prize = prize;
		this.gameId = gameId;
		this.creatorId = creatorId;
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
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(creatorId, description, endDate, gameId, id, nPlayer, name, startDate);
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
				+ ", nPlayer=" + nPlayer + ", description=" + description + ", gameId=" + gameId + ", creatorId="
				+ creatorId + "]";
	}
	
	
}