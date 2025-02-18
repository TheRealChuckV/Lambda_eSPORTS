package com.example.demo.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer>{

	



}
