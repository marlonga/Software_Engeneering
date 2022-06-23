package de.hfu.bib;

import de.hfu.db.Database;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Bibliothek {

	Bibliotheksbestand Bestand = new Bibliotheksbestand();
	ArrayList<Konto> Konten = new ArrayList<>();
	int aktuelleAusleihenID = 0;
	ArrayList<Ausleihe> alleAusleihen = new ArrayList<>();

	public void addKonto(Benutzer benutzer,Konto konto){
		Konten.add(konto);
		Database.addKonto(benutzer,konto);
	}
	public void addAusleihe(Ausleihe ausleihe,Benutzer benutzer){
		alleAusleihen.add(ausleihe);
		Database.addAusleihe(benutzer.ID,ausleihe.getIsbn());
	}


	public Ausleihobjekt searchAusleihobjekt(String searchQuery) {
		for (Ausleihobjekt o : Bestand.BibBestand){
			if (searchQuery.equals(o.getTitel())){
				return o;
			}
		}
		return null;
	}

	public void extendDeadline(int kontoID,String isbn,int days ) {
		Database.extendDeadLine(kontoID,isbn,days);
	}


	public ArrayList<Buch> getAllFromAuthor(String name) {
		ArrayList<Buch> result = new ArrayList<>();
		result = Database.getAllbuecherFromAuthor(name);
		return result;
	}

	public ArrayList<Buch> getAllFromRow(String reihe) {
		ArrayList<Buch> result = new ArrayList<>();
		result = Database.getAllbuecherFromRow(reihe);
		return result;
	}
	public int getAllBooksNumber(String isbn) {
		int result;
		result = Database.getAllbuecherAmount(isbn);
		return result;
	}

	public ArrayList<Konto> getUsers() {
		ArrayList<Konto> result = new ArrayList<>();
		result = Database.getAllKonten();
		return result;

	}

	/**
	 *
	 * @param objekt
	 */
	public void bestandErweitern(Ausleihobjekt objekt) {
		Bestand.addBibBestand(objekt);
	}


	public boolean anmelden(String benutzername, String passwort) {

		throw new UnsupportedOperationException();
	}


	public int getAmount(String isbn) {
		return Database.getAllbuecherAmount(isbn);
	}
	public int getIDfuerAusleihe() {
		return aktuelleAusleihenID++;
	}

	public ArrayList<Buch> getBestand() {
		return Database.getAllBücher();
	}

	public ArrayList<Konto> getKonten() {
		return Database.getAllKonten();
	}
	public int getIDfuerAusleihe(){
		return IDfuerAusleihe++;
	}

	public ArrayList<Ausleihe> getAlleAusleihen() {
		return Database.getAllAusleihen();
	}
}