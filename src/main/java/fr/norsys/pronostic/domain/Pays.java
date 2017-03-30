package fr.norsys.pronostic.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Pays Model
 */
@Entity
@Table(name = "PAYS")
public class Pays implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_PAYS",nullable = false,unique = true)
	private Long id;
	@Column(name="NOM")
	private String nom;
	@Column(name="LOGO")
	private String logo;


	public Pays() {
	}

	public Pays(String nom, String logo) {
		this.nom = nom;
		this.logo = logo;
	}

	public Pays(Long id, String nom, String logo) {
		this.id = id;
		this.nom = nom;
		this.logo = logo;
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

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
