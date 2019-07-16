package com.unicam.cs.pa.match;

import com.unicam.cs.pa.core.GameBoard;
import com.unicam.cs.pa.core.Utils;
import com.unicam.cs.pa.player.Player;

import java.util.Random;
/*
RESPONSABILITÀ : Fornisce implementazione di metodi utili a sottoclassi.
 */

public abstract class Match implements IMatch {

    protected static Match instanceMatch = null;
    GameBoard gameBoard = new GameBoard();
    Player[] players = new Player[2];
    Player currentPlayer;

    Match() {

    }

    Match(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        gameBoard = new GameBoard();
    }

    @Override
    public void randomStart() {
        int randomNumber = new Random().nextInt(2);
        currentPlayer = players[randomNumber];

    }


    @Override
    public void executeMatch() {
        boolean matchEnded = false;

        randomStart();
        while (!matchEnded) {


            notifyTurn(currentPlayer);
            int move = currentPlayer.getMove();
            gameBoard.dropDisc(currentPlayer.getColor(), move);
            updatePlayersBoards();

            updateBoard();

            if (gameBoard.winCheck(gameBoard.getLatestDisc(), gameBoard.getLatestDiscRow(), gameBoard.getLatestDiscCol())) {
                notifyWin(currentPlayer);
                matchEnded = true;
            }
            if (gameBoard.isDraw()) {
                notifyDraw();
                matchEnded = true;
            } else switchCurrentPlayer();
        }


    }


    protected void notifyDraw() {
        System.out.println("MATCH ENDED WITH A DRAW !");
    }

    protected void notifyTurn(Player currentPlayer) {
        System.out.println("IT'S " + Utils.getANSIUsername(currentPlayer) + " TURN!");
    }

    protected void updateBoard() {
        Utils.refreshBoard(gameBoard);
    }

    @Override
    public void switchCurrentPlayer() {
        if (currentPlayer.equals(players[0]))
            currentPlayer = players[1];
        else currentPlayer = players[0];
    }

    /*
     * Adds latestDisc to both players copy of the gameboard.
     */
    protected void updatePlayersBoards() {
        players[0].addMoveToCopy(gameBoard.getLatestDisc(), gameBoard.getLatestDiscCol());
        players[1].addMoveToCopy(gameBoard.getLatestDisc(), gameBoard.getLatestDiscCol());
    }

    protected void notifyWin(Player winner) {
        Utils.printANSIwinner(winner);
    }


}
