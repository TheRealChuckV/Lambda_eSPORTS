package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String logo;
    private int size;

    @OneToMany(mappedBy = "team") 
    private List<Player> players;
    
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Team() {
        this.players = new ArrayList<>();
    }
    
    public Team(int size) {
        this.size = size;
        this.players = new ArrayList<>();
    }

    public Team(String name, String logo, int size) {
        this.name = name;
        this.logo = logo;
        this.size = size;
        this.players = new ArrayList<>();
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public void addPlayer(Player player) {
        this.players.add(player);
        player.setTeam(this); 
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
        player.setTeam(null); 
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", players=" + players +
                '}';
    }
}