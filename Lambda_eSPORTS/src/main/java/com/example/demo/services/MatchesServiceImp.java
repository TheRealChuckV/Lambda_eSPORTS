package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Matches;
import com.example.demo.repository.MatchesRepository;

public class MatchesServiceImp  implements MatchesService{
	MatchesRepository mr ;
	
	@Override
	public List<Matches> findAll() {
		
		return (List<Matches>) mr.findAll();
	}

	@Override
	public Matches insert (Matches m) {
		
		return mr.save(m);
		
	}

	@Override
	public Matches update(Matches g) {
		
		return mr.save(g);
	}

	@Override
	public List<Matches> findbyName(Matches m) {
		 mr.findById(m.getId());
		return null;
	}

	@Override
	public void delete(Matches g) {
		mr.delete(g);
		
	}
}
