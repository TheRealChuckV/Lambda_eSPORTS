package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Player;



@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private  PlayerService playerService;


	    public boolean authenticate(String string, String password) {
	    	Player optionalPlayer;
	        if (string.contains("@")) {
	            optionalPlayer = playerService.getPlayerByEmail(string);
	        } else {
	            optionalPlayer = playerService.getPlayerByUsername(string);
	        }
	    	return optionalPlayer.checkPassword(password); // Se il giocatore esiste, verifica la password

	    }


}