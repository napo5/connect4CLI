package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;

import java.util.Random;
/*
RESPONSABILITÀ : Rappresenta giocatore artificiale.
 */

public abstract class COMPlayer extends Player {

    public COMPlayer(String username, Disc color) {
        super(username, color);
    }

    /**
     * @return integer between 1 and 7
     * useful for returning a random column number
     */

    protected int randomMove() {

        int move = new Random().nextInt(7) + 1;
        while (!gameBoardCopy.isLegit(move))
            move = new Random().nextInt(7) + 1;
        return move;
    }

}
