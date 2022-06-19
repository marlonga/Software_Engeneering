package de.hfu.bib;

import java.util.ArrayList;
import java.util.Date;

public class Konto {

	private String benutzername;
	private float guthaben;
	private String passwort;
	private int aktuellAusgelieheneBuecher;
	private ArrayList<Ausleihobjekt> alleBuecher;
	private Bibliothek bib;


	public Konto(String benutzername, float guthaben, String passwort) {
		this.benutzername = benutzername;
		this.guthaben = guthaben;
		this.passwort = passwort;
		this.aktuellAusgelieheneBuecher = 0;
		this.alleBuecher = new ArrayList<>();
	}

	public void ausleihen(Ausleihobjekt a, Bibliothek b) {
		alleBuecher.add(a);
		b.Bestand.BibBestand.remove(a);
		Date start = new Date();
		long dif = start.getTime() +1000*60*60*24*14;
		Date deadline = new Date(dif);
		Ausleihe ausleihe = new Ausleihe(b.getIDfuerAusleihe(),start,deadline);
		b.addAusleihe(ausleihe);
		System.out.println("#"+ benutzername + "<-"+ a);
	}

	public String getBenutzername() {
		return benutzername;
	}

	public float getGuthaben() {
		return guthaben;
	}

	public String getPasswort() {
		return passwort;
	}

	public int getAktuellAusgelieheneBuecher() {
		return aktuellAusgelieheneBuecher;
	}

	public ArrayList<Ausleihobjekt> getAlleBuecher() {
		return alleBuecher;
	}

	public Bibliothek getBib() {
		return bib;
	}

	public void buchVorbestellen() {
		// TODO - implement de.hfu.bib.Konto.buchVorbestellen
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public String getBuch(String name) {
		// TODO - implement de.hfu.bib.Konto.getBuch
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public void addBuch(String name) {
		// TODO - implement de.hfu.bib.Konto.addBuch
		throw new UnsupportedOperationException();
	}

	public void kontoAufloesen() {
		// TODO - implement de.hfu.bib.Konto.kontoAufl�sen
		throw new UnsupportedOperationException();
	}

	public String toString(){
		return " |de.hfu.bib.Konto: " + benutzername;
	}

}