package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomPlayerTest {

    @Test
    void getMove() {
        RandomPlayer  rp = new RandomPlayer("user", Disc.RED);
        assertTrue(rp.getMove()>=1);
        assertTrue(rp.getMove()<=7);
    }


}