package de.hfu.db;

import de.hfu.bib.Ausleihe;
import de.hfu.bib.Benutzer;
import de.hfu.bib.Buch;
import de.hfu.bib.Konto;

import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Date;


public class Database {

    private String url = "jdbc:mysql://localhost:3306/bib";
    private String username = "root";
    private String password = "Marlon1234";
    private static Connection connection;
    private static String[] listen = {"benutzer", "Konten", "Bücher", "Ausleihen"}; //

    {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Database() {
    }

    public static void resetDataBase() {
        try {
            Statement statement = null;
            for (String s : listen) {
                String x = "delete from " + s + " where 1=1;";
                statement = connection.createStatement();
                statement.execute(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readAllData() {
        System.out.println("< start Database :");
        for (String s : listen) {
            readDataFrom(s);
        }
        System.out.println(": end Database >");
    }

    public static void readDataFrom(String table) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet;
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from " + table);
            ResultSetMetaData rsmd = resultSet.getMetaData();

            int column_count = rsmd.getColumnCount();
            System.out.println("#" + table + ":");
            while (resultSet.next()) {
                for (int i = 1; i < column_count + 1; i++)
                    System.out.print(resultSet.getString(i) + " - ");
                System.out.println();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addBenutzer(Benutzer b) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String s = "insert into benutzer values(0," +
                    "'" + b.getName() + "'" + "," +
                    "'" + b.getEmail() + "'" + "," +
                    "'" + b.getPhone() + "'" + "," +
                    "'" + b.getAlter() + "'" + "," +
                    "'" + b.getFakultaet() + "'" + ");";
            Statement statement = null;
            statement = connection.createStatement();
            statement.execute(s);
            ResultSet resultSet;
            resultSet = statement.executeQuery("select id from benutzer where " + "name=" + "'" + b.getName() + "'" + " and " +
                    "email=" + "'" + b.getEmail() + "'" + " and " +
                    "phone='" + b.getPhone() + "' and " +
                    "age='" + b.getAlter() + "' and " +
                    "fakultaet='" + b.getFakultaet() + "'"
            );


            int id = 0;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
            b.setID(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addKonto(Benutzer b, Konto k) {
        String s = "insert into Konten values(" +
                "'" + b.getID() + "'" + "," +
                "'" + k.getBenutzername() + "'" + "," +
                "'" + k.getPasswort() + "'" + "," +
                "" + 0 + "" + ");";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBuch(Buch b) {
        String s = "insert into Bücher values(" +
                "'" + b.getIsbn() + "'" + "," +
                "'" + b.getTitel() + "'" + "," +
                "'" + b.getAutor() + "'" + "," +
                "'" + b.getReihe() + "'" + "," +
                "'" + b.getKategorie() + "'," +
                "" + 0 + "" + ");";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            try {
                statement.execute(s);
            } catch (SQLException e) {
            }

            s = "UPDATE bücher\n" + "SET anzahl = anzahl + 1 where isbn = " + b.getIsbn();
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Buch> getAllBücher() {
        ArrayList<Buch> result = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();

            String s = "SELECT * FROM bücher";
            ResultSet rs = statement.executeQuery(s);
            while (rs.next()) {
                Buch temp;
                String isbn = rs.getString("isbn");
                String titel = rs.getString("titel");
                String autor = rs.getString("autor");
                String reihe = rs.getString("reihe");
                String kategorie = rs.getString("kategorie");
                //rs.getInt("Anzahl");

                temp = new Buch(isbn,titel,autor,reihe,kategorie);
                result.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ArrayList<Buch> getAllbuecherFromAuthor(String a) {
        ArrayList<Buch> result = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();

            String s = "SELECT * FROM bücher where autor=" + "'" + a +"';";
            ResultSet rs = statement.executeQuery(s);
            while (rs.next()) {
                Buch temp;
                String isbn = rs.getString("isbn");
                String titel = rs.getString("titel");
                String autor = rs.getString("autor");
                String reihe = rs.getString("reihe");
                String kategorie = rs.getString("kategorie");
                //rs.getInt("Anzahl");

                temp = new Buch(isbn,titel,autor,reihe,kategorie);
                result.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ArrayList<Buch> getAllbuecherFromRow(String a) {
        ArrayList<Buch> result = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();

            String s = "SELECT * FROM bücher where reihe=" + "'" + a +"';";
            ResultSet rs = statement.executeQuery(s);
            while (rs.next()) {
                Buch temp;
                String isbn = rs.getString("isbn");
                String titel = rs.getString("titel");
                String autor = rs.getString("autor");
                String reihe = rs.getString("reihe");
                String kategorie = rs.getString("kategorie");
                //rs.getInt("Anzahl");

                temp = new Buch(isbn,titel,autor,reihe,kategorie);
                result.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int getAllbuecherAmount(String a) {
        int result = 0;
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String s = "SELECT anzahl FROM bücher where isbn=" + "'" + a +"';";
            ResultSet rs = statement.executeQuery(s);
            while (rs.next()) {
                result = rs.getInt("anzahl");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Ausleihe> getAllAusleihen() {
        ArrayList<Ausleihe> result = new ArrayList<>();

        Statement statement = null;
        try {
            statement = connection.createStatement();

            String s = "SELECT * FROM ausleihen";
            ResultSet rs = statement.executeQuery(s);
            while (rs.next()) {
                Ausleihe temp;
                int id = rs.getInt("kontoid");
                String buchisbn = rs.getString("buchisbn");
                Timestamp deadline = rs.getTimestamp("deadline");
                temp = new Ausleihe(id,deadline,buchisbn);
                result.add(temp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static ArrayList<Konto> getAllKonten() {
        ArrayList<Konto> result = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String s = "SELECT * FROM konten";
            ResultSet rs = statement.executeQuery(s);
            while (rs.next()) {
                Konto temp;
                String benutzername = rs.getString("benutzername");
                float guthaben = rs.getFloat("guthaben");
                String passwort = rs.getString("passwort");
                temp = new Konto(benutzername,guthaben, passwort);
                result.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void buchAusleihen(Buch b) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String s = "UPDATE bücher\n" + "SET anzahl = anzahl - 1 where isbn = " + b.getIsbn();
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void buchZurueckgeben(Buch b,Benutzer benutzer) {
        Statement statement = null;
        try {
            statement = connection.createStatement();

            String s = "UPDATE bücher\n" + "SET anzahl = anzahl + 1 where isbn = " + b.getIsbn();
            statement.execute(s);
            s = "DELETE FROM ausleihen where kontoid = " + benutzer.getID();
            statement.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addAusleihe(int kontoID, String isbn) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bib", "root", "Marlon1234")) {
            Timestamp Today = new Timestamp(new Date().getTime() + 14 * 24 * 60 * 60 * 1000);
            Statement stmt = connection.createStatement();
            String s = "insert into Ausleihen values(" + kontoID + ",'" + isbn + "'," + "'" + Today + "'" + ");";
            stmt.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void extendDeadLine(int KontoID, String isbn, int days) {
        String s = "";
        Timestamp currentDeadline = new Timestamp(0);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bib", "root", "Marlon1234")) {
            Statement stmt = connection.createStatement();
            s = "select deadline from Ausleihen where buchisbn=" + "'" + isbn + "'" + " and kontoid=" + "'" + KontoID + "';";
            ResultSet rs = stmt.executeQuery(s);
            while (rs.next()) {
                currentDeadline = rs.getTimestamp("deadline");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //deadline berechnen
        long temp = currentDeadline.getTime() + days * 24 * 60 * 60 * 1000;
        Timestamp newdeadline = new Timestamp(temp);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bib", "root", "Marlon1234");) {
            Statement stmt = connection.createStatement();
            s = "update Ausleihen set deadline='" + newdeadline + "' where buchisbn=" + "'" + isbn + "'" + " and kontoid=" + "'" + KontoID + "';";
            stmt.execute(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int getIDFromUser(String username) {
        ArrayList<Konto> result = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String s = "SELECT * FROM konten where benutzername=" + "'" + username + "';" ;
            ResultSet rs = statement.executeQuery(s);
            while (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
