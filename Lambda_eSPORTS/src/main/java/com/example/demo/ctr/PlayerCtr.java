package com.example.demo.ctr;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerCtr {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/preSignup")
	public String preAddPlayer(Model model) {
		model.addAttribute("playerForm", new Player());
		return "signup";
	}

	@PostMapping("/signup")
	public String addPlayer(@ModelAttribute("playerForm") Player player, RedirectAttributes redirectAttributes) {
		System.out.println(player);
		try {
			playerService.savePlayer(player);
			redirectAttributes.addFlashAttribute("successMessage", "Giocatore aggiunto con successo!");
			return "home";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Errore: " + e.getMessage());
			return "redirect:/players/preAddPlayer";
		}
	}

	@GetMapping("/preModifyPlayer/{id}")
	public String preModifyPlayer(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
		Player player = playerService.getPlayerById(id).orElse(null);
		if (player != null) {
			model.addAttribute("playerForm", player);
			return "modifyPlayer";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Giocatore non trovato.");
			return "redirect:/players/list";
		}
	}

	@PostMapping("/modifyPlayer")
	public String modifyPlayer(@ModelAttribute("playerForm") Player player, RedirectAttributes redirectAttributes) {
		try {
			playerService.updatePlayer(player);
			redirectAttributes.addFlashAttribute("successMessage", "Giocatore modificato con successo!");
			return "redirect:/players/list";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("errorMessage", "Errore: " + e.getMessage());
			return "redirect:/players/preModifyPlayer/" + player.getId();
		}
	}

	@GetMapping("/preDeletePlayer/{id}")
	public String preDeletePlayer(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
		Player player = playerService.getPlayerById(id).orElse(null);
		if (player != null) {
			model.addAttribute("playerForm", player);
			return "deletePlayer";
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "Giocatore non trovato.");
			return "redirect:/players/list";
		}
	}

	@PostMapping("/deletePlayer")
	public String deletePlayer(@ModelAttribute("playerForm") Player player, RedirectAttributes redirectAttributes) {
		try {
			playerService.deletePlayer(player.getId());
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
		List<Player> players = playerService.getPlayersByUsername(player.getUsername());
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
		List<Player> players = playerService.getPlayersByEmail(player.getEmail());
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
		List<Player> players = playerService.getAllPlayers(); // Usa il service
		model.addAttribute("players", players);
		return "playerList";
	}
}