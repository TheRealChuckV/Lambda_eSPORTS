package com.example.demo.ctr;

import com.example.demo.model.Matches;
import com.example.demo.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchesCtr {

    @Autowired
    private MatchesService matchesService;

    @GetMapping
    public List<Matches> getAllMatches() {
        return matchesService.getAllMatches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matches> getMatchById(@PathVariable int id) {
        Matches match = matchesService.getMatchById(id);
        if (match != null) {
            return ResponseEntity.ok(match);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Matches> createMatch(@RequestBody Matches match) {
        Matches createdMatch = matchesService.saveMatch(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMatch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matches> updateMatch(@PathVariable int id, @RequestBody Matches match) {
        Matches updatedMatch = matchesService.updateMatch(id, match);
        if (updatedMatch != null) {
            return ResponseEntity.ok(updatedMatch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int id) {
        matchesService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}