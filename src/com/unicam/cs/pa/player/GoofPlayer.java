package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;

import java.util.Random;

public class GoofPlayer extends COMPlayer {


    public GoofPlayer(String username, Disc color) {
        super(username, color);
    }

    @Override
    public int getMove() {
        int move = randomClose();
        while (!gameBoardCopy.isLegit(move))
            move = randomClose();
        return move;
    }

    private int randomClose() {
        int direction = new Random().nextInt(3) - 1;
        int move = gameBoardCopy.getLatestDiscCol() + direction;
        return move;

    }


}
