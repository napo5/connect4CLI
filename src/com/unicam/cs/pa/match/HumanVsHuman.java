package com.unicam.cs.pa.match;

import com.unicam.cs.pa.core.Disc;
import com.unicam.cs.pa.player.HumanPlayer;
/*
RESPONSABILITÀ : Gestisce una partita tra due utenti.
 */

public class HumanVsHuman extends Match {

    public HumanVsHuman(HumanPlayer p1, HumanPlayer p2) {
        super(p1, p2);
    }


    public HumanVsHuman() {
        players[0] = new HumanPlayer(Disc.RED);
        players[1] = new HumanPlayer(Disc.YELLOW);
    }
}


