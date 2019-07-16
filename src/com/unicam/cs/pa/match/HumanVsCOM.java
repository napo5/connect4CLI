package com.unicam.cs.pa.match;

import com.unicam.cs.pa.core.Disc;
import com.unicam.cs.pa.core.Utils;
import com.unicam.cs.pa.player.COMFactory;
import com.unicam.cs.pa.player.COMPlayer;
import com.unicam.cs.pa.player.HumanPlayer;
import com.unicam.cs.pa.player.Player;
/*
RESPONSABILITÀ : Gestisce una partita tra utente e giocatore artificiale.
 */

public class HumanVsCOM extends Match {

    public HumanVsCOM(HumanPlayer p1, COMPlayer p2) {
        super(p1, p2);
    }

    public HumanVsCOM() {
        players[0] = new HumanPlayer(Disc.RED);
        Utils.blankLine();
        COMFactory comFactory = new COMFactory();
        players[1] = comFactory.createPlayer(Disc.YELLOW);
    }

    @Override
    public void randomStart() {
        super.randomStart();
        System.out.println(currentPlayer.getUsername() + " starting!");
    }


    @Override
    protected void notifyWin(Player winner) {
        if (winner.equals(players[0]))
            System.out.println("You WIN! ");
        else System.out.println("You LOSE! ");
    }
}
