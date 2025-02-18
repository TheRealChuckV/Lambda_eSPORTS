package com.example.demo.ctr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;

@Controller
@RequestMapping("mioindirizzo")
public class MatchCtr {
	@Autowired
	MatchRepository mr;

	@GetMapping("preAddMatch")
	public String preAddMatch(Model m) {
		Match m1 = new Match();
		m.addAttribute("matchForm", m1);
		return "addMatch";

	}

	@PostMapping("addMatch")
	public String addMatch(@ModelAttribute("matchForm") Match m) {
		mr.save(m);
		return "success";
	}

	@GetMapping("preUpdateMatch")
	public String preUpdateMatch(Model m) {
		Match m1 = new Match();
		m.addAttribute("matchForm", m1);
		return "updateMatch";

	}

	@PostMapping("updateMatch")
	public String updateMatch(@ModelAttribute("matchForm") Match m) {
		mr.save(m);
		return "success";
	}

	@GetMapping("preSearchMatch")
	public String preSearchMatch(Model m) {
		Match m1 = new Match();
		m.addAttribute("matchForm", m1);
		return "searchMatch";

	}

	@PostMapping("searchMatch")
	public String searchMatches(@ModelAttribute("matchesForm") Match m1, Model m) {
		m.addAttribute("matchesForm", m1);
		return "successD";
	}

	@GetMapping("preDeleteMatch")
	public String preDeleteMatch(Model m) {
		Match m1 = new Match();
		m.addAttribute("matchesForm", m1);
		return "deleteMatches";

	}

	@PostMapping("deleteMatches")
	public String deleteMatch(@ModelAttribute("matchForm") Match m) {
		mr.delete(m);
		;
		return "success";
	}
}
