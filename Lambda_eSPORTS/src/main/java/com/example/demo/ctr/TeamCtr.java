package com.example.demo.ctr;

import com.example.demo.model.Team;
import com.example.demo.service.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamCtr {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable int id) {
        Team team = teamService.getTeamById(id);
        if (team != null) {
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team createdTeam = teamService.saveTeam(team);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable int id, @RequestBody Team team) {
        Team updatedTeam = teamService.updateTeam(id, team);
        if (updatedTeam != null) {
            return ResponseEntity.ok(updatedTeam);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/participants")
    public List<String> getParticipants() {
        return Arrays.asList("Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6", "Team 7", "Team 8");
    }
}