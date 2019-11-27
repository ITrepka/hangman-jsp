package com.hangman;

public class LetterStylesService {
    public static String hit;
    public static String notHit;

    {
        hit = "style= \"background-color: #003300;\n" +
                "color: #00C000;\n" +
                "border: 3px solid #00C000;\n" +
                "cursor: default;\"";
        notHit = "style= \"background-color: #330000;\n" +
                "color: #C00000;\n" +
                "border: 3px solid #C00000;\n" +
                "cursor: default;\"";
    }
}
