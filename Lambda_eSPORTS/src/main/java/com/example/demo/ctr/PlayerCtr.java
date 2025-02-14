package com.example.demo.ctr;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/players")
public class PlayerCtr {

	@Autowired
	private PlayerRepository pr;

	@GetMapping("/preAddPlayer")
	public String preAddPlayer(Model model) {
		model.addAttribute("playerForm", new Player());
		return "addPlayer";
	}

	@PostMapping("/addPlayer")
	public String addPlayer(@ModelAttribute("playerForm") Player player, RedirectAttributes redirectAttributes) {
		try {
			pr.save(player);
			redirectAttributes.addFlashAttribute("successMessage", "Giocatore aggiunto con successo!");
			return "redirect:/players/list";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Errore: " + e.getMessage());
			return "redirect:/players/preAddPlayer";
		}
	}

	@GetMapping("/preModifyPlayer/{id}")
	public String preModifyPlayer(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
		Optional<Player> player = pr.findById(id);
		if (player.isPresent()) {
			model.addAttribute("playerForm", player.get());
			return "modifyPlayer";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Giocatore non trovato.");
			return "redirect:/players/list";
		}
	}

	@PostMapping("/modifyPlayer")
	public String modifyPlayer(@ModelAttribute("playerForm") Player player, RedirectAttributes redirectAttributes) {
		try {
			pr.save(player);
			redirectAttributes.addFlashAttribute("successMessage", "Giocatore modificato con successo!");
			return "redirect:/players/list";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Errore: " + e.getMessage());
			return "redirect:/players/preModifyPlayer/" + player.getId();
		}
	}

	@GetMapping("/preDeletePlayer/{id}")
	public String preDeletePlayer(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
		Optional<Player> player = pr.findById(id);
		if (player.isPresent()) {
			model.addAttribute("playerForm", player.get());
			return "deletePlayer";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Giocatore non trovato.");
			return "redirect:/players/list";
		}
	}

	@PostMapping("/deletePlayer")
	public String deletePlayer(@ModelAttribute("playerForm") Player player, RedirectAttributes redirectAttributes) {
		try {
			pr.delete(player);
			redirectAttributes.addFlashAttribute("successMessage", "Giocatore eliminato con successo!");
			return "redirect:/players/list";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Errore: " + e.getMessage());
			return "redirect:/players/preDeletePlayer/" + player.getId();
		}
	}

	@GetMapping("/preFindPlayerByUsername")
	public String preFindPlayerByUsername(Model model) {
		model.addAttribute("playerForm", new Player());
		return "findPlayerByUsername";
	}

	@PostMapping("/findPlayerByUsername")
	public String findPlayerByUsername(@ModelAttribute("playerForm") Player player, Model model,
			RedirectAttributes redirectAttributes) {
		List<Player> players = pr.findByUsername(player.getUsername());
		if (!players.isEmpty()) {
			model.addAttribute("players", players);
			return "playerList";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Nessun giocatore trovato.");
			return "redirect:/players/preFindPlayerByUsername";
		}
	}

	@GetMapping("/preFindPlayerByEmail")
	public String preFindPlayerByEmail(Model model) {
		model.addAttribute("playerForm", new Player());
		return "findPlayerByEmail";
	}

	@PostMapping("/findPlayerByEmail")
	public String findPlayerByEmail(@ModelAttribute("playerForm") Player player, Model model,
			RedirectAttributes redirectAttributes) {
		List<Player> players = pr.findByEmail(player.getEmail());
		if (!players.isEmpty()) {
			model.addAttribute("players", players);
			return "playerList";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Nessun giocatore trovato.");
			return "redirect:/players/preFindPlayerByEmail";
		}
	}

	@GetMapping("/list")
	public String listPlayers(Model model) {
		List<Player> players = (List<Player>) pr.findAll();
		model.addAttribute("players", players);
		return "playerList";
	}
}