package fr.norsys.pronostic.domain;

/**
 * Pays Model
 */

public class Pays {

	private Long id;
	private String nom;
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
