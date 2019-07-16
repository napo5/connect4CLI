package com.unicam.cs.pa.player;

public class InputErrorException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong input, insert a number between 1 and 7";
    }
}
