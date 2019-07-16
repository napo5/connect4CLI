package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;

public class RandomPlayer extends COMPlayer {


    public RandomPlayer(String username, Disc color) {
        super(username, color);
    }

    @Override
    public int getMove() {
        return randomMove();
    }


}
