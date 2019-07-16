package com.unicam.cs.pa.core;

import com.unicam.cs.pa.match.MatchBuilder;

/*
RESPONSABILITÀ : esecuzione del programma
 */
public class Main {
    public static void main(String[] args) {

        MatchBuilder matchBuilder = new MatchBuilder();
        matchBuilder.playAndRematch();
    }

}
