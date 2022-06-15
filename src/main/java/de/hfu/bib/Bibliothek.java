package de.hfu.bib;

import java.util.ArrayList;
import java.util.List;

public class Bibliothek {

	Bibliotheksbestand Bestand = new Bibliotheksbestand();
	ArrayList<Konto> Konten = new ArrayList<>();
	int aktuelleAusleihenID = 0;
	ArrayList<Ausleihe> alleAusleihen = new ArrayList<>();

	public void addKonto(Konto konto){
		Konten.add(konto);
	}
	public void addAusleihe(Ausleihe ausleihe){
		alleAusleihen.add(ausleihe);
	}

	/**
	 * 
	 * @param searchQuery
	 */

	public Ausleihobjekt searchAusleihobjekt(String searchQuery) {
		for (Ausleihobjekt o : Bestand.BibBestand){
			if (searchQuery.equals(o.getTitel())){
				return o;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public List<Ausleihobjekt> getAllFromAuthor(String name) {
		// TODO - implement de.hfu.bib.Bibliothek.getAllFromAuthor
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reihe
	 */
	public List<Ausleihobjekt> getAllFromRow(String reihe) {
		// TODO - implement de.hfu.bib.Bibliothek.getAllFromRow
		throw new UnsupportedOperationException();
	}

	public void getUsers() {
		// TODO - implement de.hfu.bib.Bibliothek.getUsers
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param objekt
	 */
	public void bestandErweitern(Ausleihobjekt objekt) {
		Bestand.addBibBestand(objekt);
	}

	/**
	 * 
	 * @param benutzername
	 * @param passwort
	 */
	public boolean anmelden(String benutzername, String passwort) {
		// TODO - implement de.hfu.bib.Bibliothek.anmelden
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isbn
	 */
	public int getAmount(String isbn) {
		// TODO - implement de.hfu.bib.Bibliothek.getAmount
		throw new UnsupportedOperationException();
	}
	public int getIDfuerAusleihe() {
		return aktuelleAusleihenID++;
	}

}