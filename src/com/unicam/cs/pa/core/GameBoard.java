package com.unicam.cs.pa.core;

/*
RESPONSABILITÀ : gestione della griglia di gioco
 */
public class GameBoard {

    public final static int maxRow = 6;
    public final static int maxCol = 7;
    Disc[][] gridTable;
    // Counter to keep track of the number of discs in each row
    private int[] columnCounter = new int[7];
    private int discCounter = 0;

    // Color and coordinates of latest disc dropped in the board
    private Disc latestDisc;
    private int latestDiscRow;
    private int latestDiscCol;

    public GameBoard() {
        gridTable = new Disc[6][7];

    }

    public boolean isAValidPosition(int x, int y) {
        if (x >= 1 && x <= 6 && y >= 1 && y <= 7) {
            return true;
        } else return false;

    }

    public void dropDisc(Disc disc, int column) {

        addDisc(disc, getColumnCounter(column) + 1, column);

        columnCounter[column - 1]++;
        latestDisc = disc;
        latestDiscRow = getColumnCounter(column);
        latestDiscCol = column;
        discCounter++;
    }

    public int getColumnCounter(int column) {
        return columnCounter[column - 1];
    }

    private void addDisc(Disc disc, int row, int column) {
        try {
            gridTable[row - 1][column - 1] = disc;
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isDraw() {
        if (discCounter == 42) return true;
        else return false;
    }

    public Disc getDisc(int row, int column) {
        if (isAValidPosition(row, column))
            return gridTable[row - 1][column - 1];
        else throw new ArrayIndexOutOfBoundsException();
    }


    public boolean winCheck(Disc color, int row, int col) {

        // for checking vertical streak i just need to check how many discs are below
        int verticalCheck = directionCheck(color, Direction.DOWN, row, col);
        // summing discs on the left plus discs on the right
        int horizontalCheck = directionCheck(color, Direction.LEFT, row, col) + directionCheck(color, Direction.RIGHT, row, col) - 1;
        //   checking diagonals ,  upleft + downright and upright + downleft
        int diagonalULDRCheck = directionCheck(color, Direction.UPLEFT, row, col) + directionCheck(color, Direction.DOWNRIGHT, row, col) - 1;
        int diagonalURDLCheck = directionCheck(color, Direction.UPRIGHT, row, col) + directionCheck(color, Direction.DOWNLEFT, row, col) - 1;
        if (verticalCheck == 4 || horizontalCheck == 4 || diagonalULDRCheck == 4 || diagonalURDLCheck == 4)
            return true;
        else return false;

    }


    public int directionCheck(Disc color, Direction dir, int row, int col) {
        switch (dir) {
            case DOWN:
                return streakLenght(color, -1, 0, row, col);

            case LEFT:
                return streakLenght(color, 0, -1, row, col);

            case RIGHT:
                return streakLenght(color, 0, 1, row, col);

            case UPRIGHT:
                return streakLenght(color, 1, 1, row, col);

            case UPLEFT:
                return streakLenght(color, -1, 1, row, col);

            case DOWNRIGHT:
                return streakLenght(color, 1, -1, row, col);

            case DOWNLEFT:
                return streakLenght(color, -1, -1, row, col);

            default:
                return 0;
        }

    }


    // assumes the disc in row,col has same color as input disc
    private int streakLenght(Disc color, int directionRow, int directionCol, int row, int col) {

        int counter = 1;


        while (isAValidPosition(row + directionRow, col + directionCol)) {
            if (getDisc(row + directionRow, col + directionCol) == color) {
                counter++;

                if (directionRow < 0) directionRow--;
                else if (directionRow > 0) directionRow++;
                if (directionCol < 0) directionCol--;
                else if (directionCol > 0) directionCol++;
            } else return counter;
        }


        return counter;

    }

    public boolean isLegit(int col) {

        if (col < 1 || col > 7) return false;
        else if (getColumnCounter(col) == 6) return false;
        else return true;
    }


    public Disc getLatestDisc() {
        return latestDisc;
    }

    public int getLatestDiscRow() {
        return latestDiscRow;
    }

    public int getLatestDiscCol() {
        return latestDiscCol;
    }

}


