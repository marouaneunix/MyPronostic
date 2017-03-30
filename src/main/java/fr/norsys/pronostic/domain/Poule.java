package fr.norsys.pronostic.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "POULE")
public class Poule implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_POULE",nullable = false,unique = true)
	private Long id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "GROUPE")
	private boolean isGroupe;
	@ManyToOne
	@JoinColumn(name = "ID_COMPETITION",nullable = false)
	private Competition competition;
	@ManyToMany
	@JoinTable(
			name="POULE_PAYS",
			joinColumns = @JoinColumn(name = "ID_POULE",referencedColumnName = "ID_POULE"),
			inverseJoinColumns = @JoinColumn(name="ID_PAYS",referencedColumnName = "ID_PAYS")
	)
	private List<Pays> payss;
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
