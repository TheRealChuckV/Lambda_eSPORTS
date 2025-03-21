package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Game;

@Repository
public interface GameRepository extends JpaRepository <Game,Integer>{
	List<Game> findByName(String name);
}


