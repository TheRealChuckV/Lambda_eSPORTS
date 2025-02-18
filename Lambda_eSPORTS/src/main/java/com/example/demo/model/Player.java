package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Player {

    @Id
    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate registrationDate;
    private String role;
    private LocalDate dateOfBirth;
    @OneToMany(mappedBy = "player")
    private Set<TournamentPlayer> trnmntPlayer;

	@OneToMany(mappedBy="creator")
	private List<Tournament> tournaments;

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

    public Player(int id, String username, String password, String email, String firstName, String lastName,
            LocalDate registrationDate, String role, LocalDate dateOfBirth) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
    }

    public Player() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<TournamentPlayer> getTrnmntPlayer() {
		return trnmntPlayer;
	}

	public void setTrnmntPlayer(Set<TournamentPlayer> trnmntPlayer) {
		this.trnmntPlayer = trnmntPlayer;
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

    public void setPassword(String password) {
        this.password = password;
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

    public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass()!= obj.getClass())
            return false;
        Player other = (Player) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", username=" + username + ", email=" + email + ", firstName=" + firstName
                + ", lastName=" + lastName + ", registrationDate=" + registrationDate + ", role=" + role + ", dateOfBirth=" + dateOfBirth + "]";
    }
}