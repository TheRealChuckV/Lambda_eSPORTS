package com.example.demo.ctr;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Game;
import com.example.demo.model.Tournament;
import com.example.demo.service.GameService;
import com.example.demo.service.TournamentService;

@Controller
@RequestMapping("tournaments")
public class TournamentCtr {

    @Autowired
    private TournamentService ts;
    @Autowired
    private GameService gs;

    // Aggiunge un torneo nel db
    @GetMapping("/preAddTournament")
    public String preAddTournament(Model model) {
        List<Game> games = gs.findAll(); // Ottieni i giochi
        model.addAttribute("tournamentForm", new Tournament());
        model.addAttribute("gameForm", games); // Passa i giochi al model
        return "createTournament"; // Nome della pagina JSP senza estensione
    }

    @PostMapping("/addTournament")
    public String addTournament(@ModelAttribute("tournamentForm") Tournament trmt, Model model) {
        // Recupera il gioco selezionato
        Game selectedGame = gs.findAll().stream()
                .filter(game -> game.getId() == trmt.getGame().getId())
                .findFirst()
                .orElse(null);

        if (selectedGame != null) {
            trmt.setGame(selectedGame); // Imposta il gioco selezionato
            ts.saveTournament(trmt); // Salva il torneo nel DB
            return "redirect:/tournaments"; // Dopo aver aggiunto il torneo, reindirizza alla lista dei tornei
        } else {
            model.addAttribute("error", "Gioco non valido.");
            return "createTournament"; // Ritorna alla pagina di creazione con errore
        }
    }

    // Cancella un torneo nel db
    @GetMapping("/preDeleteTournament")
    public String preDeleteTournament(Model model) {
        model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
        return "deleteTournament"; // Nome della pagina JSP senza estensione
    }

    @PostMapping("/deleteTournament")
    public String deleteTournament(@ModelAttribute("tournamentForm") Tournament trmt) {
        ts.deleteTournament(trmt.getId()); // Cancella il torneo dal DB
        return "success"; // Reindirizza alla pagina di successo
    }

    // Trova un torneo nel db tramite gioco
    @GetMapping("/preFindTournamentByGameId")
    public String preFindTournamentByGameId(Model model) {
        List<Game> games = gs.findAll();
        model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
        model.addAttribute("gameForm", games); // Aggiunta al model
        return "findTournamentByGameId"; // Nome della pagina JSP senza estensione
    }

    @PostMapping("/findTournamentByGameId")
    public String findTournamentByGameId(@ModelAttribute("tournamentForm") Tournament trmt, Model model) {
        List<Tournament> tournaments = ts.getByGameId(trmt.getGame().getId()); // Recupera i tornei per gioco
        model.addAttribute("tournaments", tournaments); // Aggiungi i tornei alla view
        return "tournamentResults"; // Nome della pagina JSP che visualizza i risultati
    }

    // Trova un torneo nel db tramite numero di giocatori
    @GetMapping("/preFindTournamentByNPlayer")
    public String preFindTournamentByNPlayer(Model model) {
        model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
        return "findTournamentByNPlayer"; // Nome della pagina JSP senza estensione
    }

    @PostMapping("/findTournamentByNPlayer")
    public String findTournamentByNPlayer(@ModelAttribute("tournamentForm") Tournament trmt, Model model) {
        List<Tournament> tournaments = ts.getByNPlayer(trmt.getnPlayer()); // Recupera tornei per numero di giocatori
        model.addAttribute("tournaments", tournaments); // Aggiungi i tornei alla view
        return "tournamentResults"; // Nome della pagina JSP che visualizza i risultati
    }

    // Trova un torneo nel db tramite la data di inizio
    @GetMapping("/preFindTournamentByStartDate")
    public String preFindTournamentByStartDate(Model model) {
        model.addAttribute("tournamentForm", new Tournament()); // Aggiunta al model
        return "findTournamentByStartDate"; // Nome della pagina JSP senza estensione
    }

    @PostMapping("/findTournamentByStartDate")
    public String findTournamentByStartDate(@ModelAttribute("tournamentForm") Tournament trmt, Model model) {
        List<Tournament> tournaments = ts.getByStartDate(trmt.getStartDate()); // Recupera tornei per data di inizio
        model.addAttribute("tournaments", tournaments); // Aggiungi i tornei alla view
        return "tournamentResults"; // Nome della pagina JSP che visualizza i risultati
    }
}



