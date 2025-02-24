package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.model.Player;
import com.example.demo.model.Tournament;
import com.example.demo.model.TournamentPlayer;
import com.example.demo.repository.TournamentPlayerRepository;
import com.example.demo.repository.TournamentRepository;

@Service
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	private TournamentRepository tr;

	@Autowired
	private TournamentPlayerRepository tpr;

	public boolean joinTournament(int tournamentId, Player player) {
		Optional<Tournament> optionalTournament = tr.findById(tournamentId);

		if (optionalTournament.isPresent()) {
			Tournament tournament = optionalTournament.get();

			// Controlla se il giocatore è già iscritto
			boolean alreadyJoined = tpr.findAll().stream()
					.anyMatch(tp -> tp.getTournament().getId() == (tournamentId) && tp.getPlayer().equals(player));

			if (alreadyJoined) {
				return false; // Già iscritto
			}

			// Riduce i posti disponibili e salva il torneo
			tournament.addPlayer();
			tr.save(tournament);

			// Salva la partecipazione nella tabella TournamentPlayer
			TournamentPlayer tournamentPlayer = new TournamentPlayer(player, tournament);
			tpr.save(tournamentPlayer);

			return true;
		}

		return false; // Nessun posto disponibile o torneo inesistente
	}
	
	public List<Tournament> getTournamentsByPlayer(Player player) {
        List<TournamentPlayer> registrations = tpr.findByPlayer(player);
        
        // Estrarre solo i tornei dalla lista di TournamentPlayer
        return registrations.stream()
                            .map(TournamentPlayer::getTournament)
                            .collect(Collectors.toList());
    }
	
	public boolean leaveTournament(int tournamentId, Player player) {
	    List<TournamentPlayer> registrations = tpr.findByPlayer(player);
	    Tournament t;
	    for (TournamentPlayer registration : registrations) {
	        if (registration.getTournament().getId() == (tournamentId)) {
	        	t=tr.findById(tournamentId).get();
	        	t.removePlayer();
	        	tr.save(t);
	            tpr.delete(registration);
	            return true;
	        }
	    }

	    return false;
	}
	
	public Optional<Tournament> getById(int id) {
		return tr.findById(id);
	}

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
	public void saveTournament(Tournament trnmt) {
		tr.save(trnmt);
	}

	// Elimina un utente per ID
	public void deleteTournament(int id) {
		tr.deleteById(id);
	}
}