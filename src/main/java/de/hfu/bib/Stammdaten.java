package de.hfu.bib;

public class Stammdaten {

	protected int ID;
	protected String name;
	protected String email;
	protected String phone;
	protected int alter;

	public int getID() {
		return ID;
	}

	public void setID(int id){
		this.ID = id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getAlter() {
		return alter;
	}
}

