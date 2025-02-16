package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Matches;

public interface MatchesService {
	
	
	public List<Matches> findAll();

	public Matches insert(Matches m);

	public Matches update(Matches m);

	public List<Matches> findbyName(Matches m);

	public void delete(Matches m);

}

