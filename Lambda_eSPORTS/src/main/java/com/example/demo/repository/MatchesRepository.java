package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.model.Matches;
import com.example.demo.model.Tournament;

public interface MatchesRepository extends CrudRepository <Matches,Integer>{
	List<Matches> findById(Tournament id);
}
