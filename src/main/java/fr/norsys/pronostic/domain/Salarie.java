package fr.norsys.pronostic.domain;

import java.util.List;

public class Salarie {

	private Long id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private Role role;


	public Salarie() {
	}

	public Salarie(Salarie salarie) {
		this.id = salarie.getId();
		this.nom = salarie.getNom();
		this.prenom = salarie.getPrenom();
		this.username = salarie.getUsername();
		this.password = salarie.getPassword();
		this.role = salarie.getRole();

	}

	public Salarie(Long id) {
		super();
		this.id = id;
	}

	public Salarie(Long id, String nom, String prenom, String username, String password, Role role) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.role = role;

	}

	public Salarie(String nom, String prenom, String username, String password, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.role = role;

	}

	public Long getId() {
		return this.id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
