package de.hfu.bib;

public class Ausleihobjekt {

	private String isbn;
	private String titel;
	private String autor;
	private String reihe;
	private String Kategorie;

	Ausleihobjekt(String isbn,String titel,String autor,String reihe,String Kategorie){
		this.isbn = isbn;
		this.titel = titel;
		this.autor = autor;
		this.reihe = reihe;
		this.Kategorie = Kategorie;
	}


	public String getIsbn() {
		return isbn;
	}

	public String getAutor() {
		return autor;
	}

	public String getReihe() {
		return reihe;
	}

	public String getKategorie() {
		return Kategorie;
	}

	public void isbnChecksum() {
		// TODO - implement de.hfu.bib.Ausleihobjekt.isbnChecksum
		throw new UnsupportedOperationException();
	}

	public String getTitel() {
		return this.titel;
	}

	public String toString(){

		return "ISBN: " + isbn +" |Titel: " + titel + " |Autor: " + autor + " |Reihe: " + reihe + " |Kategorgie: " + Kategorie;
	}
}