package com.unicam.cs.pa.match;

import com.unicam.cs.pa.player.Player;

import java.util.Scanner;

/*
RESPONSABILITÀ : Gestisce l'input utente per creare istanza di Match desiderata.
 */


public class MatchBuilder {

    protected boolean rematch;
    protected Match match;

    public Match getMatch() {
        createNewMatch();
        return match;

    }

    public void playAndRematch() {
        boolean rematch = true;
        while (rematch) {
            getMatch();
            match.executeMatch();
            rematch = askRematch();
        }
    }


    public void createNewMatch() {

        Player[] players = new Player[2];

        printInstructions();
        Scanner matchInput = new Scanner(System.in);
        int matchType = matchInput.nextInt();

        switch (matchType) {
            case 1:
                match = new HumanVsCOM();
                break;
            case 2:
                match = new HumanVsHuman();
                break;
            case 3:
                match = new COMVsCOM();
                break;

            default:
                System.out.println("Invalid option");
                createNewMatch();
        }

    }


    private void printInstructions() {
        System.out.print("Select type of match \n" +
                "[1] 1P vs COM \n" +
                "[2] 1P VS 2P \n" +
                "[3] COM VS COM \n");
    }


    public boolean askRematch() {
        boolean rematch = false;
        System.out.println("Play Again ? (Y/n)");
        Scanner rematchInputSC = new Scanner(System.in);
        char rematchInput = rematchInputSC.next().charAt(0);


        switch (rematchInput) {
            case 'Y':
                rematch = true;
                break;
            case 'N':
                rematch = false;
                System.exit(0);
                break;
            default:
                System.out.println("Wrong Input");
                return askRematch();

        }

        return rematch;

    }

}

