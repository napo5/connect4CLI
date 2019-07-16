package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;
import com.unicam.cs.pa.core.GameBoard;

public abstract class Player implements PlayerInterface {

    String username;
    Disc color;

    //let track moves in the match
    GameBoard gameBoardCopy;


    public Player(String username, Disc color) {
        this.username = username;
        this.color = color;
        gameBoardCopy = new GameBoard();
    }

    /*
     * Let subclasses implement username inizialization
     * (via terminal input)
     * forces to inizialize color and gameboard
     */
    public Player(Disc color) {
        this.color = color;
        gameBoardCopy = new GameBoard();
    }

    public Disc getColor() {
        return color;
    }


    public String getUsername() {
        return username;
    }

    abstract public int getMove();

    public void addMoveToCopy(Disc disc, int column) {
        this.gameBoardCopy.dropDisc(disc, column);
    }

}
