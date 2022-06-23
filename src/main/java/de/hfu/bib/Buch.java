package de.hfu.bib;

public class Buch extends Ausleihobjekt {

	private Zustand Zustand;
	private boolean Vorbestellt;
	private int DeadlineVerlaengerungen;

	public Buch(String isbn, String titel, String autor, String reihe, String Kategorie) {
		super(isbn, titel, autor, reihe, Kategorie);
	}
}