package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;
import com.unicam.cs.pa.core.GameBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartPlayerTest {

    // COM is expected to put fourth disc in a row
    @Test
    void shouldCloseRow() {
        SmartPlayer sp = new SmartPlayer("smart",Disc.RED);

        sp.addMoveToCopy(Disc.RED,1);
        sp.addMoveToCopy(Disc.RED,2);
        sp.addMoveToCopy(Disc.RED,3);

        assertTrue(sp.getMove()==4);

    }
}