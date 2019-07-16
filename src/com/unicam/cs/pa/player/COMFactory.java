package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
RESPONSABILITÀ : Gestisce l'input utente per creare istanza di COMPlayer desiderata.
 */

public class COMFactory implements PlayerFactory {
    @Override
    public COMPlayer createPlayer(Disc color) {

        printCOMInstructions();
        Scanner comInput = new Scanner(System.in);
        int comType = 0;
        try {
            comType = comInput.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Wrong Input! Please try again.");
            return createPlayer(color);
        }


        COMPlayer com = null;

        switch (comType) {
            case 1:
                com = new RandomPlayer("EasyCOM", color);
                break;
            case 2:
                com = new GoofPlayer("GoofCOM", color);
                break;
            case 3:
                com = new SmartPlayer("SmartCOM", color);
                break;

            default:
                System.out.println("Invalid option");
                createPlayer(color);
        }
        return com;

    }

    @Override
    public Player getPlayer() {
        return null;
    }

    private void printCOMInstructions() {
        System.out.println("COM Player setup :");
        System.out.println("Select type of COM player");
        System.out.println("[1] (Easy) Random COM");
        System.out.println("[2] (Medium) Goof COM");
        System.out.println("[3] (Hard) Smart COM");
    }
}
