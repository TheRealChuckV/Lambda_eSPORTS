package com.example.demo.service;


import org.springframework.stereotype.Service;
import com.example.demo.model.Chat;
import com.example.demo.repository.ChatRepository;

@Service
public class ChatServiceImp implements ChatService {
ChatRepository cr;
	@Override
	public Chat sendMessage(Chat c) {
		
		return cr.save(c);
	}

	

	

}
