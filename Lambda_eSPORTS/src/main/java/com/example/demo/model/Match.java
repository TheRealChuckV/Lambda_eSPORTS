package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.data.annotation.Id;

public class Match {

	@Id
	private int id;
	private Tournament tournament;
	private Player player1;
	private Player player2;
	private LocalDateTime dateTime;
	private String result;

	public Match() {
	}

	public Match(Tournament tournament, Player player1, Player player2, LocalDateTime dateTime, String result) {
		this.tournament = tournament;
		this.player1 = player1;
		this.player2 = player2;
		this.dateTime = dateTime;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Match matches = (Match) o;
		return id == matches.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Matches{" + "id=" + id + ", tournament=" + tournament + ", player1=" + player1 + ", player2=" + player2
				+ ", dateTime=" + dateTime + ", result='" + result + '\'' + '}';
	}
}