package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;

public class SmartPlayer extends COMPlayer {
    public SmartPlayer(String username, Disc color) {
        super(username, color);
    }

    /*

    SmartCOM move checks if there is a row of three discs with same color:
    if he can close a four-in-a-row and win he wins
    if the opponent can close a four-in-a-row he denies it.

*/
    @Override
    public int getMove() {
        return fourthInARow();
    }

    private int fourthInARow() {
        for (int i = 1; i <= 7; i++) {

            if (gameBoardCopy.winCheck(Disc.RED, gameBoardCopy.getColumnCounter(i)+1, i)) {

                return i;
            }
        }

        for (int i = 1; i <= 7; i++) {
            if (gameBoardCopy.winCheck(Disc.YELLOW, gameBoardCopy.getColumnCounter(i)+1, i)) {

                return i;
            }
        }


        // if there are no winning moves
        return randomMove();
    }
}
