package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Team;

public interface TeamService {

	public List<Team> getAllTeams();

	public Team getTeamById(int id);

	public Team saveTeam(Team team);

	public Team updateTeam(int id, Team team);

	public void deleteTeam(int id);
}
