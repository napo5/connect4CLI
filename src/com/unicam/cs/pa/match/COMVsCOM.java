package com.unicam.cs.pa.match;

import com.unicam.cs.pa.core.Disc;
import com.unicam.cs.pa.core.Utils;
import com.unicam.cs.pa.player.COMFactory;
import com.unicam.cs.pa.player.COMPlayer;
import com.unicam.cs.pa.player.Player;

/*
RESPONSABILITÀ : Gestisce una partita tra due giocatori virtuali.

 */
public class COMVsCOM extends Match {

    private boolean fastMode;

    public COMVsCOM(COMPlayer p1, COMPlayer p2) {
        super(p1, p2);
    }

    public COMVsCOM(COMPlayer p1, COMPlayer p2, boolean fastMode) {
        super(p1, p2);
        this.fastMode = true;
    }

    public COMVsCOM() {
        COMFactory comFactory = new COMFactory();
        players[0] = comFactory.createPlayer(Disc.RED);
        Utils.blankLine();
        players[1] = comFactory.createPlayer(Disc.YELLOW);
    }

    @Override
    protected void notifyTurn(Player currentPlayer) {
        if (fastMode) {// does not print
        } else super.notifyTurn(currentPlayer);

    }

    @Override
    protected void updateBoard() {
        if (fastMode) {// does not print
        } else super.updateBoard();

    }

    @Override
    protected void notifyWin(Player winner) {
        super.notifyWin(winner);
        if (fastMode) Utils.printBoard(gameBoard);
    }
}

