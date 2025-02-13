package com.example.demo.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;

@Controller
@RequestMapping("mioindirizzo")
public class GameCTR {
	@Autowired
	GameRepository gr;

	@GetMapping("preInsertGame")
	public String preInsertGame(Model m) {
		Game g = new Game();
		m.addAttribute("gameForm", g);
		return "insertGame";

	}

	@PostMapping("insertGame")
	public String insertGame(@ModelAttribute("gameForm") Game g) {
		System.out.println(
				"hello" + " " + g.getId() + " " + g.getName() + " " + g.getDescription() + " " + g.getImage());
		gr.save(g);
		return "success";
	}

	@GetMapping("preUpdateGame")
	public String preUpdateGame(Model m) {
		Game g = new Game();
		m.addAttribute("gameForm", g);
		return "updateGame";

	}
	@PostMapping("updateGame")
	public String updateGame(@ModelAttribute ("gameForm") Game g ) {
	System.out.println("hello"+ " " + g.getId()+ g.getName()+g.getDescription());
	gr.save(g);	
	return "success";
	}

	@GetMapping("preSearchGame")
	public String preSearchGame(Model m) {
		m.addAttribute("gameForm", new Game());
		return "searchGame";

	}

	@PostMapping("searchGame")
	public String searchGame(@ModelAttribute("gameForm") Game g, Model m) {
		System.out.println("hello" + " " + g.getId() + " " + g.getName() + " " + g.getDescription() + g.getImage());
		List<Game> d = gr.findByName(g.getName());
		System.out.println(d);
		m.addAttribute("gameForm", d);
		return "successD";
	}

	@GetMapping("preDeleteGame")
	public String preDeleteGame(Model m) {
		m.addAttribute("gameForm", new Game());
		return "deleteGame";

	}

	@PostMapping("deleteGame")
	public String deleteGame(@ModelAttribute("gameForm") Game g) {
		System.out.println(
				"hello" + " " + g.getId() + " " + g.getName() + " " + g.getDescription() + " " + g.getImage());
		gr.delete(g);
		;
		return "success";
	}
}