package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tournament;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Integer>{
	
	List<Tournament> findByGameId(int gameId);
	List<Tournament> findByNPlayer(int nPlayer);
      List<Tournament> findByStartDate(Date startDate);
}
