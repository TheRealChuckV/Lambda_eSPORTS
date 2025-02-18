package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.model.Match;
import com.example.demo.model.Tournament;

public interface MatchRepository extends CrudRepository <Match,Integer>{
	List<Match> findById(Tournament id);
}
