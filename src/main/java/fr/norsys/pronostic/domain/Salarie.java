package fr.norsys.pronostic.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SALARIE")
public class Salarie implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_SALARIE",nullable = false,unique = true)
	private Long id;

	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	@Column(name="USERNAME",unique = true)
	private String username;
	@Column(name="PASSWORD")
	private String password;
	@ManyToOne
	@JoinColumn(name = "ID_ROLE",nullable = false)
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
