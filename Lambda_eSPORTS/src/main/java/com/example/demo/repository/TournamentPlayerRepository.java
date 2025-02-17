package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TournamentPlayer;

public interface TournamentPlayerRepository extends JpaRepository<TournamentPlayer, Integer>{

}
