package de.hfu.bib;

import de.hfu.db.Database;

import java.io.IOException;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) {

        //Teil 1
         Bibliothek x = new Bibliothek();
         for (int i = 0; i < 10; i++){
             Ausleihobjekt buchx = new Ausleihobjekt("123" + i, "Star Wars: "+ (i+1), "Niklas","1","Informatik");
             x.bestandErweitern(buchx);
         }

        System.out.println("Teil 1 Buecher: ");
         for (int i = 0; i < 10; i++){
             System.out.println(x.Bestand.BibBestand.get(i));
         }

         //Teil 2

        Benutzer a = new Benutzer(1,"Marlon","marlon@gmail", "0123 4567", 20,"Informatik");
        Benutzer b = new Benutzer(2,"Robin","robin@gmail", "0123 4568", 20,"Informatik");
        a.kontoErstellen("guest1","12345");
        b.kontoErstellen("guest2","1234");
        x.addKonto(a.getKonto());
        x.addKonto(b.getKonto());
        System.out.println();
        System.out.println("Teil 2 de.hfu.bib.Benutzer: ");
        System.out.println(a);
        System.out.println(b);

        //Teil 3
        System.out.println();
        System.out.println("Teil 3.1 ausleihen ausführen: ");
        for (int i = 0; i < 5; i++)
        {
            if(i<3) {
                a.getKonto().ausleihen(x.searchAusleihobjekt("Star Wars: "+(i+1)),x);
            }
            int j = i+5;
            b.getKonto().ausleihen(x.searchAusleihobjekt("Star Wars: " +(j+1)),x);
        }
        System.out.println();
        System.out.println("Teil 3.2 ausleihen ansehen: ");
        for (Ausleihe ausleihe : x.alleAusleihen){
            System.out.println(ausleihe);
        }



    }
}
