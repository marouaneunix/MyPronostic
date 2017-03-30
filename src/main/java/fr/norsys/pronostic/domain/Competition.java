package fr.norsys.pronostic.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "COMPETITION")
public class Competition implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_COMPETITION",nullable = false, unique = true)
	private Long id;

	@Column(name="NOM")
	private String nom;
	@Column(name="ANNEE")
	private LocalDate annee;

	public Competition(Long id, String nom, LocalDate annee) {
		this.id = id;
		this.nom = nom;
		this.annee = annee;
	}

	public Competition() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getAnnee() {
		return this.annee;
	}

	public void setAnnee(LocalDate annee) {
		this.annee = annee;
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
		Competition other = (Competition) obj;
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
