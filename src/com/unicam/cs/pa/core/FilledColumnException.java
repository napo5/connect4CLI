package com.unicam.cs.pa.core;

public class FilledColumnException extends Exception {
    @Override
    public String getMessage() {
        return "The column selected is full!";
    }
}
