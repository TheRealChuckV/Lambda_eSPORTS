package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(int id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(int id, Team team) {
        Optional<Team> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            team.setId(id); // Important: Set the ID of the team to be updated
            return teamRepository.save(team);
        }
        return null;
    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}