package fr.norsys.pronostic.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Table(name = "RENCONTRE")
public class Rencontre implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_RENCONTRE",nullable = false, unique = true)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "ID_PAYS_1",nullable = false)
	private Pays pays1;
	@ManyToOne
	@JoinColumn(name = "ID_PAYS_2",nullable = false)
	private Pays pays2;
	@Column(name="BUT_1")
	private int but1;
	@Column(name="BUT_2")
	private int but2;
	@ManyToOne
	@JoinColumn(name = "ID_POULE",nullable = false)
	private Poule poule;
	@Column(name="DATE")
	private LocalDateTime dateRencontre;

	public Rencontre() {
	}

	public Rencontre(Long id) {
		this.id = id;
	}

	public Rencontre(Long id, Pays pays1, Pays pays2, int but1, int but2, Poule poule, LocalDateTime dateRencontre) {
		this.id = id;
		this.pays1 = pays1;
		this.pays2 = pays2;
		this.but1 = but1;
		this.but2 = but2;
		this.poule = poule;
		this.dateRencontre = dateRencontre;
	}

	public Rencontre(Pays pays1, Pays pays2, int but1, int but2, Poule poule, LocalDateTime dateRencontre) {
		this.pays1 = pays1;
		this.pays2 = pays2;
		this.but1 = but1;
		this.but2 = but2;
		this.poule = poule;
		this.dateRencontre = dateRencontre;
	}

	public Long getId() {
		return this.id;
	}

	public Pays getPays1() {
		return this.pays1;
	}

	public void setPays1(Pays pays1) {
		this.pays1 = pays1;
	}

	public Pays getPays2() {
		return this.pays2;
	}

	public void setPays2(Pays pays2) {
		this.pays2 = pays2;
	}

	public int getBut1() {
		return this.but1;
	}

	public void setBut1(int but1) {
		this.but1 = but1;
	}

	public int getBut2() {
		return this.but2;
	}

	public void setBut2(int but2) {
		this.but2 = but2;
	}

	public Poule getPoule() {
		return this.poule;
	}

	public void setPoule(Poule poule) {
		this.poule = poule;
	}

	public LocalDateTime getDateRencontre() {
		return this.dateRencontre;
	}

	public void setDateRencontre(LocalDateTime dateRencontre) {
		this.dateRencontre = dateRencontre;
	}
}
