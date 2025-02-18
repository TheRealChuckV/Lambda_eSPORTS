package com.example.demo.service;

import com.example.demo.model.Matches;


import java.util.List;


public interface MatchesService {

	List<Matches> getAllMatches();

	Matches getMatchById(int id);

	Matches saveMatch(Matches match);

	Matches updateMatch(int id, Matches match);

	void deleteMatch(int id);
}