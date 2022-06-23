package de.hfu.bib;

import de.hfu.UI.UserInterface;
import de.hfu.db.Database;

import java.text.ParseException;


public class main {
    public static void main(String[] args) throws ParseException {

        Database db = new Database();

        /*
        Database.resetDataBase();

        Benutzer phil = new Benutzer(0, "Phil", "@phil", "1234", 21, "Informatik");
        Database.addBenutzer(phil);
        phil.kontoErstellen("derrPhil", "phil1234");

        Database.addBuch(new Buch("187","An der Hochschule 2","David Beckham","neue Reihe","Lernen"));
        Database.addBuch(new Buch("69","An der Hochschule 4","David  ROsi","neue Reihe","Lernen"));

        Database.readAllData();

         */

        UserInterface ui = new UserInterface();

    }
}
