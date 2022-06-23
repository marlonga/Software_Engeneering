package de.hfu.bib;

import de.hfu.db.Database;


public class Benutzer extends Stammdaten {
	private String Fakultaet;
	private Konto konto;

	public Benutzer(int ID, String name, String email, String phone, int alter, String fakultaet) {
		this.ID = ID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.alter = alter;
		this.Fakultaet = fakultaet;
	}

	public Konto getKonto() {
		return konto;
	}

	public void kontoErstellen(String bn, String pw) {
		this.konto = new Konto(bn,0,pw);
		Database.addKonto(this,this.konto);
	}

	public String toString(){
		return "ID: " + ID +" |Name: "+ name + " |Email: " + email + " |Phonenumb.: " + phone + " |Alter: " + alter + " |Fakultaet: " + Fakultaet +" #"+ konto;
	}

	public String getFakultaet() {
		return Fakultaet;
	}

}