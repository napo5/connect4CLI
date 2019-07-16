package com.unicam.cs.pa.player;

public class notExistentColumnException extends Exception {
    @Override
    public String getMessage() {
        return "The number must be between 1 and 7! Try again.";
    }
}
