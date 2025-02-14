package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Game;

@Repository
public interface GameRepository extends CrudRepository <Game,Integer>{
	List<Game> findByName(String name);
	
}
