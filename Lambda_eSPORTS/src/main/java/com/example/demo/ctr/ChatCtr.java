package com.example.demo.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Chat;
import com.example.demo.service.ChatServiceImp;



@Controller
@RequestMapping("mioindirizzo")
public class ChatCtr {
	ChatServiceImp cr;
	@GetMapping("preSendMessage")
	public String preSendMessage(Model m) {
		Chat c = new Chat();
		m.addAttribute("chatForm", c);
		return "sendMessage";

	}

	
	@PostMapping("sendMessage")
	public String sendMessage(@ModelAttribute("chatForm") Chat c) {
		cr.sendMessage(c);
		return "success";
	}
	
	
}
