package de.hfu.bib;

import java.util.ArrayList;

public class Bibliotheksbestand {
	ArrayList<Ausleihobjekt> BibBestand = new ArrayList<>();

	public void addBibBestand(Ausleihobjekt a){
		BibBestand.add(a);
	}
	/**
	 *
	 * @param kategorie
	 */
	public int getAnzahlKategorie(String kategorie) {
		// TODO - implement de.hfu.bib.Bibliotheksbestand.getAnzahlKategorie
		throw new UnsupportedOperationException();
	}

}