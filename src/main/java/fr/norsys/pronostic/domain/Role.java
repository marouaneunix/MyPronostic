package fr.norsys.pronostic.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_ROLE",nullable = false, unique = true)
	private Long id;
	@Column(name = "NOM")
	private String nom;

	public Role() {
	}

	public Role(Long id, String nom) {
		this.id = id;
		this.nom = nom;
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
}
