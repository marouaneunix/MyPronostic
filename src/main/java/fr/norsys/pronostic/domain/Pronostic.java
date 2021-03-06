package fr.norsys.pronostic.domain;

public class Pronostic {

	private Long id;
	private int but1;
	private int but2;
	private int note;
	private Rencontre rencontre;
	private Salarie salarie;

	public Pronostic() {
	}

	public Pronostic(Long id, int but1, int but2, int note, Rencontre rencontre, Salarie salarie) {
		this.id = id;
		this.but1 = but1;
		this.but2 = but2;
		this.note = note;
		this.rencontre = rencontre;
		this.salarie = salarie;
	}

	public Pronostic(int but1, int but2, int note, Rencontre rencontre, Salarie salarie) {
		this.but1 = but1;
		this.but2 = but2;
		this.note = note;
		this.rencontre = rencontre;
		this.salarie = salarie;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public Rencontre getRencontre() {
		return this.rencontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	public Salarie getSalarie() {
		return this.salarie;
	}

	public void setSalarie(Salarie salarie) {
		this.salarie = salarie;
	}
}
