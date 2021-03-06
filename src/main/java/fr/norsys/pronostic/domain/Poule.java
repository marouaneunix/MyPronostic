package fr.norsys.pronostic.domain;

import java.util.Optional;

public class Poule {

	private Long id;
	private String nom;
	private boolean isGroupe;
	private Competition competition;

	public Poule() {
	}

	public Poule(String nom, boolean isGroupe, Competition competition) {
		this.nom = nom;
		this.isGroupe = isGroupe;
		this.competition = competition;
	}

	public Poule(Long id, String nom, boolean isGroupe, Competition competition) {
		this.id = id;
		this.nom = nom;
		this.isGroupe = isGroupe;
		this.competition = competition;
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

	public boolean isGroupe() {
		return this.isGroupe;
	}

	public void setGroupe(boolean groupe) {
		this.isGroupe = groupe;
	}

	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Poule other = (Poule) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
