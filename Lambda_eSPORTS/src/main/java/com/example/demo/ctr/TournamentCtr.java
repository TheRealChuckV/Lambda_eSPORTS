package com.example.demo.ctr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Tournament;
import com.example.demo.repository.TournamentRepository;

@Controller
@RequestMapping("tournaments")
public class TournamentCtr {

	@Autowired
	private TournamentRepository tr;

	// Aggiunge un torneo nel db

	@GetMapping("/preAddTournament")
	public String preAddTournament(Model model) {
		model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
		return "addTournament"; // Nome della pagina JSP senza estensione
	}

	@PostMapping("/addTournament")
	public String addTournament(@ModelAttribute("tournamentForm") Tournament trmt) {
		tr.save(trmt);
		// Reindirizziamo alla pagina di successo
		return "success";
	}

	// Aggiorna un torneo nel db

	@GetMapping("/preModifyTournament")
	public String preModifyTournament(Model model) {
		model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
		return "modifyTournament"; // Nome della pagina JSP senza estensione
	}

	@PostMapping("/modifayTournament")
	public String modifyTournament(@ModelAttribute("tournamentForm") Tournament trmt) {
		tr.save(trmt);
		// Reindirizziamo alla pagina di successo
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
		tr.deleteById(trmt.getId());
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
		if (!tr.findByGameId(trmt.getGameId()).isEmpty()) {
			List<Tournament> trmts = tr.findByGameId(trmt.getGameId());
			model.addAttribute("tournamentForm", trmts);
			System.out.println(trmts);
			return "success";
		}
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
		if (!tr.findByNPlayer(trmt.getnPlayer()).isEmpty()) {
			List<Tournament> trmts = tr.findByNPlayer(trmt.getnPlayer());
			model.addAttribute("tournamentForm", trmts);
			System.out.println(trmts);
			return "success";
		}
		return null;
	}
	
	// Trova un torneo nel db tramite la data di in inizio

		@GetMapping("/preFindTournamentByStartDate")
		public String preFindTournamentByStartDate(Model model) {
			model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
			return "findTournamentByStartDate"; // Nome della pagina JSP senza estensione
		}

		@PostMapping("/findTournamentByStartDate")
		public String findTournamentByStartDate(@ModelAttribute("tournamentForm") Tournament trmt, Model model) {
			if (!tr.findByStartDate(trmt.getStartDate()).isEmpty()) {
				List<Tournament> trmts = tr.findByStartDate(trmt.getStartDate());
				model.addAttribute("tournamentForm", trmts);
				System.out.println(trmts);
				return "success";
			}
			return null;
		}

}
