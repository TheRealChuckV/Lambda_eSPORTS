package com.example.demo.ctr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Player;
import com.example.demo.model.Game;
import com.example.demo.model.Tournament;
import com.example.demo.service.GameService;
import com.example.demo.service.PlayerService;

import com.example.demo.service.TournamentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("tournaments")
public class TournamentCtr {

	@Autowired
	private TournamentService ts;
	@Autowired
	private GameService gs;
	@Autowired
	private PlayerService ps;


	// Aggiunge un torneo nel db

	@GetMapping("/preAddTournament")
	public String preAddTournament(Model model) {
		List<Game> games = gs.findAll();
		model.addAttribute("tournamentForm", new Tournament());
		model.addAttribute("gameForm", games); // Aggiunta al model
		return "createTournament"; // Nome della pagina JSP senza estensione
	}

	@PostMapping("/addTournament")
	public String addTournament(@ModelAttribute("tournamentForm") Tournament trmt, HttpSession session) {
		System.out.println(session);
		String s = (String) session.getAttribute("loginString");

		if (!s.contains("@"))
			trmt.setCreator(ps.getPlayerByUsername(s));
		else {
			s = (String) session.getAttribute("email");
			trmt.setCreator(ps.getPlayerByEmail(s));
		}
		ts.saveTournament(trmt);
		return "tournaments";
	}

	// Aggiorna un torneo nel db

	@GetMapping("/preUpdateTournament")
	public String preModifyTournament(Model model) {
		model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
		return "updateTournament"; // Nome della pagina JSP senza estensione
	}

	@PostMapping("/updateTournament")
	public String updateTournament(@ModelAttribute("tournamentForm") Tournament trmt) {
		ts.saveTournament(trmt);
		return "success";
	}

	// Cancella un torneo nel db

	@GetMapping("/preDeleteTournament")
	public String preDeleteTournament(Model model) {
		model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
		return "deleteTournament"; // Nome della pagina JSP senza estensione
	}

	@PostMapping("/deleteTournament")
	public String deleteTournament(@ModelAttribute("tournamentForm") Tournament trmt) {
		ts.deleteTournament(trmt.getId());
		// Reindirizziamo alla pagina di successo
		return "success";
	}

	// Trova un torneo nel db tramite gioco

	@GetMapping("/preFindTournamentByGameId")
	public String preFindTournamentByGameId(Model model) {
		model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
		return "findTournamentById"; // Nome della pagina JSP senza estensione
	}

	@PostMapping("/findTournamentByGameId")
	public String findTournamentByGameId(@ModelAttribute("tournamentForm") Tournament trmt, Model model) {
		model.addAttribute("tournamentForm", ts.getByGameId(trmt.getGame().getId()));
		return null;
	}

	// Trova un torneo nel db tramite in numero di giocatori

	@GetMapping("/preFindTournamentByNPlayer")
	public String preFindTournamentByNPlayer(Model model) {
		model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
		return "findTournamentById"; // Nome della pagina JSP senza estensione
	}

	@PostMapping("/findTournamentByNPlayer")
	public String findTournamentByNPlayer(@ModelAttribute("tournamentForm") Tournament trmt, Model model) {
		model.addAttribute("tournamentForm", ts.getByNPlayer(trmt.getnPlayer()));
		return "success";

	}

	// Trova un torneo nel db tramite la data di in inizio

	@GetMapping("/preFindTournamentByStartDate")
	public String preFindTournamentByStartDate(Model model) {
		model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
		return "findTournamentByStartDate"; // Nome della pagina JSP senza estensione
	}

	@PostMapping("/findTournamentByStartDate")
	public String findTournamentByStartDate(@ModelAttribute("tournamentForm") Tournament trmt, Model model) {
		model.addAttribute("tournamentForm", ts.getByStartDate(trmt.getStartDate()));
		return "success";

	}

	@GetMapping("/tournaments")
	public String getAllTournaments(Model model) {
		List<Tournament> tournaments = ts.getAllTournaments();
		model.addAttribute("tournaments", tournaments);
		return "tournamentList"; // Il nome del file JSP senza estensione
	}

	@PostMapping("/join/{id}")
	public String joinTournament(@PathVariable int id, Model model, HttpSession session) {
		System.out.println("inserito");
		String s = (String) session.getAttribute("loginString");
		if (s.contains("@"))
			ts.joinTournament(id, ps.getPlayerByEmail(s));
		else
			ts.joinTournament(id, ps.getPlayerByUsername(s));
		return "tournaments"; // Ricarica la pagina dopo l'iscrizione
	}
	
	@GetMapping("/myTournaments")
	public String myTournaments(Model model, HttpSession session) {
		String s = (String) session.getAttribute("loginString");
		Player player;
		if (s.contains("@"))
			player = ps.getPlayerByEmail(s);
		else
			player = ps.getPlayerByUsername(s);
		List<Tournament> myTournaments = ts.getTournamentsByPlayer(player);
        model.addAttribute("myTournaments", myTournaments);
		return "myTournaments"; // Nome della pagina JSP senza estensione
	}
	
	@PostMapping("/leave/{id}")
	public String leaveTournament(@PathVariable int id, HttpSession session, Model model) {
	    String s = (String) session.getAttribute("loginString");
	    Player player;
	    System.out.println("popi");
		if (s.contains("@"))
			player = ps.getPlayerByEmail(s);
		else
			player = ps.getPlayerByUsername(s);

	    boolean success = ts.leaveTournament(id, player);

	    if (!success) {
	        model.addAttribute("error", "Errore nel lasciare il torneo.");
	    }

	    return "tournaments";
	}
	
	@GetMapping("/view/{id}")
	public String viewTournament(@PathVariable int id, Model model) {
	    Optional<Tournament> tournament = ts.getById(id);
	    
	    if (tournament == null) {
	        return "redirect:/my-tournaments"; // Se non esiste, torna indietro
	    }

	    model.addAttribute("tournament", tournament);
	    return "tournamentDetails"; // Mostra la pagina di dettaglio
	}
	
}
