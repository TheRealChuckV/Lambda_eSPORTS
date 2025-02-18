package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;

@Service
public class GameServiceImp implements GameService {
	GameRepository gr ;
	
	@Override
	public List<Game> findAll() {
		
		return (List<Game>) gr.findAll();
	}

	@Override
	public Game insert (Game g) {
		
		return gr.save(g);
		
	}

	@Override
	public Game update(Game g) {
		
		return gr.save(g);
	}

	@Override
	public List<Game> findbyName(Game g) {
		
		return  gr.findByName(g.getName());
	}

	@Override
	public void delete(Game g) {
		gr.delete(g);
		
	}

}
