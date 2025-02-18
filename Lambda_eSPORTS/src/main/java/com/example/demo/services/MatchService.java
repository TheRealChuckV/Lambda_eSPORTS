package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Match;

public interface MatchService {
	
	
	public List<Match> findAll();

	public Match insert(Match m);

	public Match update(Match m);

	public List<Match> findbyName(Match m);

	public void delete(Match m);

}

