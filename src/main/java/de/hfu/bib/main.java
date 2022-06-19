package de.hfu.bib;

import de.hfu.db.Database;

import java.text.ParseException;

import java.io.IOException;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws ParseException {

        //Teil 1
         Bibliothek x = new Bibliothek();
         for (int i = 0; i < 10; i++){
             Ausleihobjekt buchx = new Ausleihobjekt("123" + i, "Star Wars: "+ (i+1), "Niklas","1","Informatik");
             x.bestandErweitern(buchx);
         }

        Benutzer phil = new Benutzer(0, "Phil", "@phil", "1234", 21, "Informatik");
        db.addBenutzer(phil);
        phil.kontoErstellen("derrPhil", "phil1234");

        db.addBuch(new Buch("123456789","An der Hochschule 2","David Beckham","neue Reihe","Lernen"));
        db.addBuch(new Buch("123456789","An der Hochschule 2","David Beckham","neue Reihe","Lernen"));
        db.addBuch(new Buch("123456789","An der Hochschule 2","David Beckham","neue Reihe","Lernen"));

        db.readAllData();

        System.out.println(phil);

        //int in der Datenbank verwenden
    }
}
