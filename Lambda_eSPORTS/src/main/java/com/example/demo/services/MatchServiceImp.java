package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;

public class MatchServiceImp  implements MatchService{
	MatchRepository mr ;
	
	@Override
	public List<Match> findAll() {
		
		return (List<Match>) mr.findAll();
	}

	@Override
	public Match insert (Match m) {
		
		return mr.save(m);
		
	}

	@Override
	public Match update(Match g) {
		
		return mr.save(g);
	}

	@Override
	public List<Match> findbyName(Match m) {
		 mr.findById(m.getId());
		return null;
	}

	@Override
	public void delete(Match g) {
		mr.delete(g);
		
	}
}
