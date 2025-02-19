package com.example.demo.service;

import com.example.demo.model.Matches;


import java.util.List;


public interface MatchesService {

	public List<Matches> getAllMatches();

	public Matches getMatchById(int id);

	public Matches saveMatch(Matches match);

	public Matches updateMatch(int id, Matches match);

	public void deleteMatch(int id);
}


