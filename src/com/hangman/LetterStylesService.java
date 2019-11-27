package com.hangman;

public class LetterStylesService {
    public static String hit;
    public static String notHit;

    static {
        hit = "background-color: #003300;color: #00C000; border: 3px solid #00C000;cursor: default";
        notHit = "background-color: #330000; color: #C00000; border: 3px solid #C00000; cursor: default;";
    }
}
