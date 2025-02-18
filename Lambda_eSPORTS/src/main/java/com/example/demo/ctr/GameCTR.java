package com.example.demo.ctr;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Game;
import com.example.demo.service.GameServiceImp;

@Controller
@RequestMapping("mioindirizzo")
public class GameCTR {
	@Autowired
	GameServiceImp gr;

	@GetMapping("/")
	public String listGame(Model model) {
		model.addAttribute("gameForm", gr.findAll());
		return "home";
	}

	@GetMapping("preInsertGame")
	public String preInsertGame(Model m) {
		Game g = new Game();
		m.addAttribute("gameForm", g);
		return "insertGame";

	}

	@PostMapping("insertGame")
	public String insertGame(@ModelAttribute("gameForm") Game g) {
		gr.insert(g);
		return "success";
	}

	@GetMapping("preUpdateGame")
	public String preUpdateGame(Model m) {
		Game g = new Game();
		m.addAttribute("gameForm", g);
		return "updateGame";

	}

	@PostMapping("updateGame")
	public String updateGame(@ModelAttribute("gameForm") Game g) {
		gr.update(g);
		return "success";
	}

	@GetMapping("preSearchGame")
	public String preSearchGame(Model m) {
		m.addAttribute("gameForm", new Game());
		return "searchGameByName";

	}

	@PostMapping("searchGameByName")
	public String searchGame(@ModelAttribute("gameForm") Game g, Model m) {
		m.addAttribute("gameForm", gr.findbyName(g));
		return "successD";
	}

	@GetMapping("preDeleteGame")
	public String preDeleteGame(Model m) {
		m.addAttribute("gameForm", new Game());
		return "deleteGame";

	}

	@PostMapping("deleteGame")
	public String deleteGame(@ModelAttribute("gameForm") Game g) {
		gr.delete(g);
		
		return "success";
	}
}