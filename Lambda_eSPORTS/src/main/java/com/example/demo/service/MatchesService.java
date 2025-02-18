package com.example.demo.service;

import com.example.demo.model.Matches;


import java.util.List;


public interface MatchesService {

	List<Matches> getAllMatches();

	Matches getMatchById(int id);

	Matches saveMatch(Matches match);

<<<<<<< HEAD
	Matches updateMatch(int id, Matches match);

	void deleteMatch(int id);
}
=======
    public Matches updateMatch(int id, Matches match) {
        Optional<Matches> existingMatch = matchesRepository.findById(id);
        if (existingMatch.isPresent()) {
            match.setId(id);
            return matchesRepository.save(match);
        }
        return null;
    }

    public void deleteMatch(int id) {
        matchesRepository.deleteById(id);
    }
}
>>>>>>> 097d9f03df6fee22d43d7cbe70b52ee7c9b2f582
