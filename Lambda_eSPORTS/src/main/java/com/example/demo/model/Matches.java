package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;

public class Matches {

	@Id
	private int id;
	private Tournament tournament;
	private List<Player> team1;
	private List<Player> team2;
	private LocalDateTime dateTime;
	private String result;

	public Matches() {
	}

	public Matches(Tournament tournament, List<Player> team1, List<Player> team2, LocalDateTime dateTime,
			String result) {
		this.tournament = tournament;
		this.team1 = team1;
		this.team2 = team2;
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

	public List<Player> getTeam1() {
		return team1;
	}

	public void setTeam1(List<Player> team1) {
		this.team1 = team1;
	}

	public List<Player> getTeam2() {
		return team2;
	}

	public void setTeam2(List<Player> team2) {
		this.team2 = team2;
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
		Matches matches = (Matches) o;
		return id == matches.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Matches{" + "id=" + id + ", tournament=" + tournament + ", team1=" + team1 + ", team2=" + team2
				+ ", dateTime=" + dateTime + ", result='" + result + '\'' + '}';
	}
}