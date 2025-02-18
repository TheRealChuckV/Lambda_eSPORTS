package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;

import java.util.List;


@Service
public class LoginServiceImpl implements LoginService{
	  private final PlayerRepository playerRepository;

	    public LoginServiceImpl(PlayerRepository playerRepository) {
	        this.playerRepository = playerRepository;
	    }

	    public boolean authenticate(String username, String password) {
	    	List<Player> players = playerRepository.findByUsername(username);
	    	for(Player p: players) {
	    		if(p.checkPassword(password));
	    		return true;
	    	}
	    	return false;
	    }


}