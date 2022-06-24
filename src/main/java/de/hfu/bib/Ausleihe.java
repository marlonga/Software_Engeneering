package de.hfu.bib;

import de.hfu.db.Database;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.lang.Number.*;

public class Ausleihe {

	private int ID;
	private String isbn;
	private Timestamp deadline;

	public Ausleihe(int ID, Timestamp deadline,String isbn) {
		this.ID = ID;
		this.deadline = deadline;
		this.isbn = isbn;
	}



	public String toString(){
		return "ID: " + ID + " |deadline: " + deadline + " |isbn: "+ isbn;
	}



	public int getID() {
		return ID;
	}

	public String getIsbn() {
		return isbn;
	}

	public Date getDeadline() {
		return deadline;
	}
}