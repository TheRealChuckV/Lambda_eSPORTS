package com.example.demo.ctr;

import com.example.demo.model.Player;
import com.example.demo.model.Team;
import com.example.demo.model.Tournament;
import com.example.demo.service.PlayerServiceImpl;
import com.example.demo.service.TeamServiceImpl;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teams")
public class TeamCtr {

    @Autowired
    private TeamServiceImpl teamService;
    @Autowired
    private PlayerServiceImpl ps;

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

    @GetMapping("/create")
    public String showCreateTeam(Model model,HttpSession session) {
        model.addAttribute("teamForm", new Team());
        return "createTeam"; // La vista JSP o HTML per il form
    }

    // Aggiungi il team al database
    @PostMapping("/create")
    public String createTeam(@ModelAttribute Team team, HttpSession session) {
        // Salva il team nel database
    	Optional<Tournament> t = (Optional<Tournament>) session.getAttribute("tournament");
    	Tournament tournament = t.orElseThrow(() -> new RuntimeException("Torneo non trovato nella sessione!"));
    	team.setSize(tournament.getTeamSize());
    	team.setTournament(tournament);
    	teamService.saveTeam(team);
        return "viewTournament"; // Redirigi alla lista dei team dopo il salvataggio
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
    
    @PostMapping("/add/{id}")
    public String addToTeam(@PathVariable int id,  HttpSession session) {
    	String s = (String) session.getAttribute("loginString");
    	Player p;
    	if(s.contains("@")) p = ps.getPlayerByEmail(s);
    	else p = ps.getPlayerByUsername(s);
    	ps.addPlayerToTeam(id, p);
    	return "redirect:/tournaments/view/" + id;
    }
    
    @GetMapping("/participants")
    public List<String> getParticipants() {
        return Arrays.asList("Team 1", "Team 2", "Team 3", "Team 4", "Team 5", "Team 6", "Team 7", "Team 8");
    }
}