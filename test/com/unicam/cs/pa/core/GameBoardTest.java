package com.unicam.cs.pa.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void verticalStreak() {
        GameBoard gb = new GameBoard();
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,1);

        int streak =  gb.directionCheck(Disc.RED,Direction.DOWN,4,1);
        assertTrue(streak==4);
        assertTrue(gb.winCheck(Disc.RED,4,1));
    }

    @Test
    void verticalWin(){

    }

    @Test
    void horizontalStreak() {
        GameBoard gb = new GameBoard();
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,3);
        gb.dropDisc(Disc.RED,2);
        gb.dropDisc(Disc.RED,4);

        int streak =  gb.directionCheck(Disc.RED,Direction.RIGHT,1,1);
        assertTrue(streak==4);
    }

    @Test
    void shouldNotWin() {
        GameBoard gb = new GameBoard();
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,3);
        gb.dropDisc(Disc.RED,2);



        assertFalse(gb.winCheck(Disc.RED,1,1));
    }

    @Test
    void horizontalReverseStreak(){
        GameBoard gb = new GameBoard();
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,3);
        gb.dropDisc(Disc.RED,2);
        gb.dropDisc(Disc.RED,4);

        int streak =  gb.directionCheck(Disc.RED,Direction.LEFT,1,4);
        assertTrue(streak==4);
    }

    @Test
    void diagonalStreak() {
        GameBoard gb = new GameBoard();

        gb.dropDisc(Disc.YELLOW,1);
        gb.dropDisc(Disc.RED,2);
        gb.dropDisc(Disc.RED,3);
        gb.dropDisc(Disc.RED,4);

        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.YELLOW,2);
        gb.dropDisc(Disc.RED,3);
        gb.dropDisc(Disc.RED,4);

        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,2);
        gb.dropDisc(Disc.YELLOW,3);
        gb.dropDisc(Disc.RED,4);

        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,2);
        gb.dropDisc(Disc.RED,3);
        gb.dropDisc(Disc.YELLOW,4);

        int streak =  gb.directionCheck(Disc.YELLOW,Direction.UPRIGHT,1,1);
        assertTrue(streak==4);
        assertTrue(gb.winCheck(Disc.YELLOW,2,2));
    }

    @Test
    void latestDisc(){
        GameBoard gb = new GameBoard();
        gb.dropDisc(Disc.YELLOW,1);

        assertTrue(gb.getLatestDisc()==Disc.YELLOW);
        assertTrue(gb.getLatestDiscCol()==1);
        assertTrue(gb.getLatestDiscRow()==1);
    }

    @Test
    void isLegit(){
        GameBoard gb = new GameBoard();
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,1);
        gb.dropDisc(Disc.RED,1);

        assertFalse(gb.isLegit(1));
        assertFalse(gb.isLegit(0));
        assertFalse(gb.isLegit(9));
    }

    @Test
    void isDraw() {
        GameBoard gb = new GameBoard();
        for (int i = 1; i <= 6; i++) {

            gb.dropDisc(Disc.RED, 1);
            gb.dropDisc(Disc.RED, 2);
            gb.dropDisc(Disc.RED, 3);
            gb.dropDisc(Disc.RED, 4);
            gb.dropDisc(Disc.RED, 5);
            gb.dropDisc(Disc.RED, 6);
            gb.dropDisc(Disc.RED, 7);
        }

        assertTrue(gb.isDraw());
    }
}