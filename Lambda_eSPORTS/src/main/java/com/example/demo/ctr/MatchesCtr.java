package com.example.demo.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Matches;
import com.example.demo.repository.MatchesRepository;

@Controller
@RequestMapping("mioindirizzo")
public class MatchesCtr {
	@Autowired
	MatchesRepository mr;

	@GetMapping("preAddMatches")
	public String preAddMatches(Model m) {
		Matches m1 = new Matches();
		m.addAttribute("matchesForm", m1);
		return "addMatches";

	}

	@PostMapping("addMatches")
	public String addMatches(@ModelAttribute("matchesForm") Matches m) {
		System.out.println("hello" + " " + m.getId() + " " + m.getTournament() + " " + m.getPlayer1() + " "
				+ m.getPlayer2() + " " + m.getDateTime() + " " + m.getResult());
		mr.save(m);
		return "success";
	}

	@GetMapping("preUpdateMatches")
	public String preUpdateMatches(Model m) {
		Matches m1 = new Matches();
		m.addAttribute("matchesForm", m1);
		return "updateMatches";

	}

	@PostMapping("updateMatches")
	public String updateMatches(@ModelAttribute("matchesForm") Matches m) {
		System.out.println("hello" + " " + m.getId() + " " + m.getTournament() + " " + m.getPlayer1() + " "
				+ m.getPlayer2() + " " + m.getDateTime() + " " + m.getResult());
		mr.save(m);
		return "success";
	}

	@GetMapping("preSearchMatches")
	public String preSearchMatches(Model m) {
		Matches m1 = new Matches();
		m.addAttribute("matchesForm", m1);
		return "searchMatches";

	}

	@PostMapping("searchMatches")
	public String searchMatches(@ModelAttribute("matchesForm") Matches m1, Model m) {
		System.out.println("hello" + " " + m1.getId() + " " + m1.getTournament() + " " + m1.getPlayer1() + " "
				+ m1.getPlayer2() + " " + m1.getDateTime() + " " + m1.getResult());
		List<Matches> d = mr.findByTournament(m1.getTournament());
		System.out.println(d);
		m.addAttribute("matchesForm", d);
		return "successD";
	}

	@GetMapping("preDeleteMatches")
	public String preDeleteMatches(Model m) {
		Matches m1 = new Matches();
		m.addAttribute("matchesForm", m1);
		return "deleteMatches";

	}

	@PostMapping("deleteMatches")
	public String deleteMatches(@ModelAttribute("matchesForm") Matches m) {
		System.out.println("hello" + " " + m.getId() + " " + m.getTournament() + " " + m.getPlayer1() + " "
				+ m.getPlayer2() + " " + m.getDateTime() + " " + m.getResult());
		mr.delete(m);
		;
		return "success";
	}
}
