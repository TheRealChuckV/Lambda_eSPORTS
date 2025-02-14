package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.demo.model.Tournament;
import com.example.demo.repository.TournamentRepository;

@Service
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	private TournamentRepository tr;

	// Ottieni tutti gli utenti
	public List<Tournament> getAllTournaments() {
		return (List<Tournament>) tr.findAll();
	}

	public List<Tournament> getByGameId(int id) {
		List<Tournament> trnmts = new ArrayList<>();
		if (!tr.findByGameId(id).isEmpty()) {
			trnmts = tr.findByGameId(id);
		}
		return trnmts;
	}

	public List<Tournament> getByStartDate(Date date) {
		List<Tournament> trnmts = new ArrayList<>();
		if (!tr.findByStartDate(date).isEmpty()) {
			trnmts = tr.findByStartDate(date);
		}
		return trnmts;
	}

	public List<Tournament> getByNPlayer(int n) {
		List<Tournament> trnmts = new ArrayList<>();

		if (!tr.findByNPlayer(n).isEmpty()) {
			trnmts = tr.findByNPlayer(n);
			
		}
		return trnmts;
	}

	// Ottieni un utente per ID
	public Optional<Tournament> getUserById(int id) {
		return tr.findById(id);
	}

	// Salva un nuovo utente
	public Tournament saveTournament(Tournament trmt) {
		return tr.save(trmt);
	}

	// Elimina un utente per ID
	public void deleteTournament(int id) {
		tr.deleteById(id);
	}
}