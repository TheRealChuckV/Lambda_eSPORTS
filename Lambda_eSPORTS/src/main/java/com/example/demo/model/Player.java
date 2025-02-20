package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate registrationDate;
    private String role;
    private LocalDate dateOfBirth;

    
    @OneToMany
    @JoinColumn(name="id_chat")
    private List<Chat> message;
    
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;


    public Player() {
    }

    public Player(String username, String rawPassword, String email, String firstName, String lastName, String role, LocalDate dateOfBirth) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.registrationDate = LocalDate.now();
        this.dateOfBirth = dateOfBirth;
        this.password = hashPassword(rawPassword);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String rawPassword) {
        this.password = hashPassword(rawPassword);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private String hashPassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }

    public boolean checkPassword(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, this.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth, email, firstName, id, lastName, password, registrationDate, role, username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player other = (Player) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", username=" + username + ", email=" + email + ", firstName=" + firstName
                + ", lastName=" + lastName + ", registrationDate=" + registrationDate + ", role=" + role + ", dateOfBirth=" + dateOfBirth + "]";
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}