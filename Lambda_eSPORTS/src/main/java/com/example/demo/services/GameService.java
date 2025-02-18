package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Game;

public interface GameService {

	public List<Game> findAll();

	public Game insert(Game g);

	public Game update(Game g);

	public List<Game> findbyName(Game g);

	public void delete(Game g);

}
