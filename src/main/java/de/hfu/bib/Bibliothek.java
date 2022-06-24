package de.hfu.bib;

import de.hfu.db.Database;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class Bibliothek {

	//Bibliotheksbestand Bestand = new Bibliotheksbestand();
	private ArrayList<Buch> Bestand = new ArrayList<>();
	ArrayList<Konto> Konten = new ArrayList<>();
	private int IDfuerAusleihe = 0;

	ArrayList<Ausleihe> alleAusleihen = new ArrayList<>();

	public Bibliothek() {
		Bestand = Database.getAllBücher();
		Konten = Database.getAllKonten();
		alleAusleihen = Database.getAllAusleihen();
	}

	public void addKonto(Benutzer benutzer,Konto konto){
		Konten.add(konto);
		Database.addKonto(benutzer,konto);
	}
	public void addAusleihe(Ausleihe ausleihe,Benutzer benutzer){
		alleAusleihen.add(ausleihe);
		Database.addAusleihe(benutzer.ID,ausleihe.getIsbn());
	}


	public Buch searchBuch(String searchQuery) {
		for (Buch o : Bestand){
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
		return Database.getAllbuecherAmount(isbn);
	}



	public void bestandErweitern(Buch b) {
		Bestand.add(b);
		Database.addBuch(b);
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