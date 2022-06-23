package de.hfu.UI;

public class Pair {
    private String command;
    private String fullcommand;
    Pair(String command,String fullcommand) {
        this.command = command;
        this.fullcommand = fullcommand;
    }

    public String getCommand() {
        return command;
    }

    public String getFullcommand() {
        return fullcommand;
    }
}