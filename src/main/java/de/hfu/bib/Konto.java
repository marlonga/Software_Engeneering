package de.hfu.bib;

import de.hfu.db.Database;

import javax.swing.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Konto {

	private String benutzername;
	private float guthaben;
	private String passwort;
	private int aktuellAusgelieheneBuecher;
	private ArrayList<Ausleihobjekt> alleBuecher;
	private Bibliothek bib;



	public Konto(String benutzername,float guthaben, String passwort) {
		this.benutzername = benutzername;
		this.guthaben = guthaben;
		this.passwort = passwort;
		this.aktuellAusgelieheneBuecher = 0;
		this.alleBuecher = new ArrayList<>();
	}

	public void ausleihen(Buch buch, Bibliothek b,Benutzer benutzer) {
		if(Database.getAllbuecherAmount(buch.getIsbn()) > 0) {
			alleBuecher.add(buch);
			b.getBestand().remove(buch);
			Timestamp start = new Timestamp(new Date().getTime());
			long dif = start.getTime() + 1000 * 60 * 60 * 24 * 14;
			Timestamp deadline = new Timestamp(dif);
			Ausleihe ausleihe = new Ausleihe(b.getIDfuerAusleihe(), deadline, buch.getIsbn());
			b.addAusleihe(ausleihe, benutzer);
			Database.buchAusleihen(buch);
		}else{
			System.out.println("Buch " + buch.getIsbn() + " ist im Moment nicht verfügbar");
		}
	}

	public void buchRueckgabe(Buch buch,Benutzer benutzer){
		Database.buchZurueckgeben(buch, benutzer);
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

	public void kontoAufloesen() {
		// TODO - implement de.hfu.bib.Konto.kontoAufl�sen
		throw new UnsupportedOperationException();
	}

	public String toString(){
		return " |Konto: " + benutzername;
	}

}