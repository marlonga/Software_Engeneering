package de.hfu.bib;

public class EBook extends Ausleihobjekt {

	private String download;

	EBook(String isbn, String titel, String autor, String reihe, String Kategorie) {
		super(isbn, titel, autor, reihe, Kategorie);
	}
}