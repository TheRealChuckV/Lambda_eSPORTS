package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Game {
	@Id
	private int id;
	private String name;
	private String description;
	private String image;

	public Game(int id, String name, String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
	}

	public Game() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String imagine) {
		this.image = imagine;
}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", description=" + description + ", imagine=" + image + "]";
	}
	
	
	
}


