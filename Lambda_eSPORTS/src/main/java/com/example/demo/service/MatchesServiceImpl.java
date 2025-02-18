package com.example.demo.service;

import com.example.demo.model.Matches;
import com.example.demo.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchesServiceImpl implements MatchesService{

    @Autowired
    private MatchesRepository matchesRepository;

    public List<Matches> getAllMatches() {
        return matchesRepository.findAll();
    }

    public Matches getMatchById(int id) {
        Optional<Matches> match = matchesRepository.findById(id);
        return match.orElse(null);
    }

    public Matches saveMatch(Matches match) {
        return matchesRepository.save(match);
    }

    public Matches updateMatch(int id, Matches match) {
        Optional<Matches> existingMatch = matchesRepository.findById(id);
        if (existingMatch.isPresent()) {
            match.setId(id); // Assicurati che l'ID sia impostato
            return matchesRepository.save(match);
        } else {
            return null;
        }
    }

    public void deleteMatch(int id) {
        matchesRepository.deleteById(id);
    }
}