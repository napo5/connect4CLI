package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;
import com.unicam.cs.pa.core.FilledColumnException;

import java.util.Scanner;

//import org.junit.jupiter.api.Test;

/*
RESPONSABILITÀ : Rappresenta giocatore utente, gestisce il suo input da terminale.
 */
public class HumanPlayer extends Player {


    public HumanPlayer(String username, Disc color) {
        super(username, color);
    }

    public HumanPlayer(Disc color) {
        super(color);
        System.out.print("Insert your username :");
        Scanner nameInput = new Scanner(System.in);
        String playerName = nameInput.nextLine();
        this.username = playerName;
    }

    @Override
    public int getMove() {

        int move;

        try {
            move = humanInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getMove();
        }
        return move;

    }


    public int humanInput() throws InputErrorException, notExistentColumnException, FilledColumnException {
        int columnInput;

        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) columnInput = input.nextInt();
        else throw new InputErrorException();
        if (columnInput < 1 || columnInput > 7)
            throw new notExistentColumnException();
        if (gameBoardCopy.getColumnCounter(columnInput) == 6)
            throw new FilledColumnException();

        return columnInput;
    }
}
