package de.hfu.UI;

import de.hfu.bib.*;
import de.hfu.db.Database;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;

public class UserInterface {
    private ArrayList<Pair> befehle = new ArrayList<>();
    private String username = "";
    private Bibliothek bib = new Bibliothek();
    private boolean exitBool = false;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public UserInterface() {
        befehle.add(new Pair("login", "       log in    *type in username and password"));
        befehle.add(new Pair("new login", "   new login *create new user and type in new username and  new password"));
        befehle.add(new Pair("addBook", "     --addBook  <isbn> <titel> <autor> <reihe> <kategorie> :: erstellt einen neuen Eintrag in die Bibliothek "));
        befehle.add(new Pair("allBooks", "    --allBooks                                            :: gibt alle Bücher der Bibliothek aus "));
        befehle.add(new Pair("fromAuthor", "  --fromAuthor                                          :: gibt alle Bücher eines Autors aus "));
        befehle.add(new Pair("bookAmount", "  --bookAmount                                          :: gibt die Anzahl eins Buches aus "));
        befehle.add(new Pair("fromRow", "     --fromRow                                             :: gibt alle Bücher einer Reihe aus "));
        befehle.add(new Pair("alleAusleihen", "     --alleAusleihen                                            :: gibt alle Ausleihen aus "));
        befehle.add(new Pair("extendDeadline", "     --extendDeadline <isbn> <days>                                        :: verlängert die deadline des angemeldetetn Nutzers um <days> tage für das Buch <isbn> "));
        befehle.add(new Pair("allUsers", "     --allUsers                                           :: gibt alle Konten aus "));
        befehle.add(new Pair("rentBook", "     --rentBook <isbn>                                           :: leihe das Buch <isbn> aus "));
        befehle.add(new Pair("returnBook", "     --returnBook <isbn>                                           :: gebe das Buch <isbn> zurück "));
        //Befehlsausgabe
        befehlsausgabe();
        System.out.println(" WILLKOMMEN!!!");
        System.out.println(" WILLKOMMEN!!!");
        System.out.println(" WILLKOMMEN!!!");
        System.out.println(" WILLKOMMEN!!!");
        System.out.println();


        while (!exitBool) {
            while (anmeldung()) {
            }
            ;
            while (bibInterface()) {
            }
            ;
        }
    }

    public void befehlsausgabe() {
        System.out.println("#System: alle verfügbaren Befehle:");
        for (Pair p : befehle) {
            System.out.println("  " + p.getCommand() + p.getFullcommand());
        }
    }

    public String readInput() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String eingabe = null;
        try {
            eingabe = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return eingabe;
    }

    public boolean anmeldung() {

        System.out.println("#System: Einloggen erforderlich oder neu Anmeldung nötig");
        System.out.print(ANSI_YELLOW + ">user:" + ANSI_RESET); //Startabfrage hinzufügen
        String answer = readInput();
        switch (answer) {
            case "RESET":
                Database.resetDataBase();
                System.out.println(ANSI_BLUE + "#System: Komplette Datenbank-Einträge gelöscht :)" + ANSI_RESET);
                return true;
            case "exit":
                exitBool = true;
                return false;
            case "new login":
                answer = "";

                System.out.print(ANSI_BLUE + "  Name: " + ANSI_RESET);
                answer += readInput() + " ";
                System.out.print(ANSI_BLUE + "  Email: " + ANSI_RESET);
                answer += readInput() + " ";
                System.out.print(ANSI_BLUE + "  Phone: " + ANSI_RESET);
                answer += readInput() + " ";
                System.out.print(ANSI_BLUE + "  Age: " + ANSI_RESET);
                answer += readInput() + " ";
                System.out.print(ANSI_BLUE + "  Fakulteat: " + ANSI_RESET);
                answer += readInput() + " ";
                String[] tempanswer = answer.split(" ");

                int age = Integer.parseInt(tempanswer[3]);

                Benutzer b = new Benutzer(0, tempanswer[0], tempanswer[1], tempanswer[2], age, tempanswer[4]);

                Database.addBenutzer(b);

                answer = "";

                System.out.print("  Benutzername: ");
                answer += readInput() + " ";
                System.out.print("  Passwort: ");
                answer += readInput();

                if (existsKonto(answer)) {
                    System.out.println("#System: Dieses Konto ist belegt!");
                } else {
                    String search[] = answer.split(" ");
                    bib.addKonto(b, new Konto(search[0], 0, search[1]));
                    System.out.println("#System: Neues Konto erstellt!");
                    return true;
                }
            case "login":
                answer = "";
                System.out.print("  Benutzername: ");
                answer += readInput() + " ";
                System.out.println("  Passwort: ");
                answer += readInput() + " ";
                if (existsKonto(answer)) {
                    System.out.println("#System: Anmeldung gelungen");
                    return false;
                } else {
                    System.out.println("#System: Anmeldung gescheitert");
                    return true;
                }
            case "":
                System.out.println("#System: keine Eingabe ");
                return true;
            default:
                System.out.println("#System: Falsche Eingabe[" + answer + "]");
                return true;
        }
    }

    public boolean existsKonto(String answer) {
        String[] search = answer.split(" ");
        String eins = search[0];
        String zwei = search[1];
        for (Konto k : Database.getAllKonten()) {
            if (eins.equals(k.getBenutzername()) && zwei.equals(k.getPasswort())) {
                username = search[0];
                return true;
            }
        }
        return false;
    }

    public boolean bibInterface() {
        if (exitBool == true) {
            return false;
        }
        System.out.print(ANSI_YELLOW + ">" + username + ":" + ANSI_RESET); //Startabfrage hinzufügen
        String answer = readInput();

        String s = befehle.get(0).getCommand();
        switch (answer) {

            case "exit":
                exitBool = true;
                return false;
            case "?":
                befehlsausgabe();
                return true;
            case "logout":
                System.out.println(ANSI_BLUE +"#System: Abmeldung erfolgreich! "+ ANSI_RESET);
                return false;
            case "":
                System.out.println("#System: keine Eingabe ");
                return true;
            default:
                String[] temp = answer.split(" ");
                boolean questionmark = false;
                if (answer.contains("?")) {
                    questionmark = true;
                    answer = answer.replace("?", "");
                }
                temp[0] = temp[0].replace("?","");
                if (existsInBefehle(temp[0])) {
                    if (questionmark) {
                        for (Pair p : befehle) {
                            if (p.getCommand().equals(answer)) {
                                System.out.println("#System: " + p.getFullcommand());
                                return true;
                            }
                        }
                    }
                    //richtiger befehl

                    System.out.println(temp[0]);
                    switch (temp[0]) {
                        case "addBook":
                            bib.bestandErweitern(new Buch(temp[1], temp[2], temp[3], temp[4], temp[5]));
                            System.out.println(ANSI_BLUE + "#System: Book added to Libary{" + temp[1] + "," + temp[2] + "," + temp[3] + "," + temp[4] + "," + temp[5] + "}" + ANSI_RESET);
                            break;
                        case "allBooks":
                            ArrayList<Buch> output = Database.getAllBücher();
                            System.out.println(ANSI_BLUE + "#System: all Books in Libary" + ANSI_RESET);
                            for(Buch b : output){
                                System.out.println(ANSI_BLUE + "  " + b + ANSI_RESET);
                            }
                            break;
                        case "alleAusleihen":
                            System.out.println("#System: all Ausleihen in Libary");
                            ArrayList<Ausleihe> outputb = bib.getAlleAusleihen();

                            for(Ausleihe a : outputb){
                                System.out.println("  " + a);
                            }
                            break;
                        case "extendDeadline":
                                bib.extendDeadline(Database.getIDFromUser(username),temp[1],Integer.parseInt(temp[2]));
                                break;
                        case"allUsers":
                            ArrayList<Konto> outputK = bib.getKonten();
                            System.out.println(ANSI_BLUE + "#System: all Users in Libary" + ANSI_RESET);
                            for(Konto b : outputK){
                                System.out.println("  " + b);
                            }
                            break;
                        case "bookAmount":
                            int bookamount = bib.getAllBooksNumber(temp[1]);
                            if(bookamount > 0){
                                System.out.println("  Amount:"+ bookamount);
                            }else {
                                System.out.println(ANSI_RED + "#System: Book not available  " + ANSI_RESET);
                            }
                            break;
                        case "fromAuthor":

                            ArrayList<Buch> outputa = bib.getAllFromAuthor(temp[1]);

                            if(outputa.size() > 0){
                                System.out.println("  from " + temp[1] +":");
                                for(Buch b : outputa){
                                    System.out.println("  " + b);
                                }
                            } else {
                                System.out.println(ANSI_RED + "#System: No books of this author " + ANSI_RESET);
                            }
                            break;
                        case "fromRow":
                            ArrayList<Buch> outputc = bib.getAllFromRow(temp[0]);
                            if(outputc.size() > 0){
                                System.out.println("#System: all Books from Row");
                                for(Buch a : outputc){
                                    System.out.println("  " + a);
                                }
                            } else {
                                System.out.println(ANSI_RED + "#System: No Books in this Row" + ANSI_RESET);
                            }
                            break;
                    }

                } else {
                    System.out.println( ANSI_RED + "#System: Falsche Eingabe [" + answer + "]" + ANSI_RESET);
                }
                return true;
        }
    }

    public boolean existsInBefehle(String answer) {
        for (Pair p : befehle) {
            if (p.getCommand().equals(answer)) {
                return true;
            }
        }
        return false;
    }
}