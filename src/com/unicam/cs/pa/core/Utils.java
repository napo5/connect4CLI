package com.unicam.cs.pa.core;

import com.unicam.cs.pa.player.Player;
/*
RESPONSABILITÀ : fornisce metodi di utility per la stampa su terminale
 */

public final class Utils {

    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String rowDelimiter = "+---+---+---+---+---+---+---+";
    private static final String rowIndicator = "| 1 | 2 | 3 | 4 | 5 | 6 | 7 |";

    // primo for al contrario
    //apposta

    public static final void printBoard(GameBoard board) {

        for (int i = 6; i >= 1; i--) {
            System.out.println(rowDelimiter);
            for (int j = 1; j <= 7; j++) {
                System.out.print("|");
                System.out.print(Utils.getCellImage(board.getDisc(i, j)));

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println(rowDelimiter);
        System.out.println(rowDelimiter);
        System.out.println(rowIndicator);
        System.out.println(rowDelimiter);
    }

    public static final String getANSIColour(Disc color) {
        if (color.equals(Disc.RED)) {
            return ANSI_RED;
        } else return ANSI_YELLOW;

    }

    public static final String getANSIColourBackground(Disc color) {
        if (color.equals(Disc.RED)) {
            return ANSI_RED_BACKGROUND;
        } else return ANSI_YELLOW_BACKGROUND;

    }

    public static final String getANSIUsername(Player player) {
        return Utils.getANSIColour(player.getColor()) + player.getUsername() + Utils.ANSI_RESET;

    }


    public static String getCellImage(Disc color) {

        if (color == null) {
            return "   ";
        } else return Utils.getANSIColourBackground(color) + "   " + Utils.ANSI_RESET;

    }


    public static void printANSIwinner(Player player) {

        if (player.getColor().equals(Disc.RED))
            System.out.println(Utils.ANSI_RED + player.getUsername() + Utils.ANSI_RESET + " WINS!");
        if (player.getColor().equals(Disc.YELLOW))
            System.out.println((Utils.ANSI_YELLOW + player.getUsername() + Utils.ANSI_RESET) + " WINS!");

    }

    /**
     * su terminale , le seguenti due righe spostano tutto il contenuto in alto
     * simulando un refresh della pagina
     */
    public static void refreshBoard(GameBoard gameBoard) {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Utils.printBoard(gameBoard);

    }

    public static void blankLine() {
        System.out.println();
    }


}
