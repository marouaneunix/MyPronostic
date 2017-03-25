package fr.norsys.pronostic.domain;

public class Role {
	private Long id;
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
