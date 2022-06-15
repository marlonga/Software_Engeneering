package de.hfu.bib;

import java.text.DecimalFormat;
import java.util.Date;
import java.lang.Number.*;

public class Ausleihe {

	private int ID;
	private Date start;
	private Date deadline;

	public Ausleihe(int ID, Date start, Date deadline) {
		this.ID = ID;
		this.start = start;
		this.deadline = deadline;
	}

	public DecimalFormat calculateFee() {
		// TODO - implement de.hfu.bib.Ausleihe.calculateFee
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param wochen
	 */
	public void extendDeadline(int wochen) {
		// TODO - implement de.hfu.bib.Ausleihe.extendDeadline
		throw new UnsupportedOperationException();
	}

	public String toString(){
		return "ID: " + ID + " |Start date: " + start + " |deadline: " + deadline;
	}

}