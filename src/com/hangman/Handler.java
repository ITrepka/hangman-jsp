package com.hangman;

import java.util.ArrayList;
import java.util.List;

public class Handler {
    public static String password;
    public static String hiddenPassword;
    public static int mistakesNumber;
    public static List<Letter> letters;

    static {
        password = PasswordService.getRandomPassword();
        hiddenPassword = PasswordService.hidePassword(password);
        mistakesNumber = 0;
        letters = generateAlphabet();
    }

    private static List<Letter> generateAlphabet() {
        List<Letter> letters = new ArrayList<>();
        for (char letter = 'A'; letter <= 'Z' ; letter++) {
            letters.add(new Letter(letter + ""));
        }
        return letters;
    }


    public static boolean checkTheLetter(int letterIndex) {
       return password.contains(letters.get(letterIndex).getSymbol());
    }

    public static List<String> getLettersSymbols() {
        List<String> symbols = new ArrayList();
        for (Letter letter: letters) {
            symbols.add(letter.getSymbol());
        }
        return symbols;
    }

    public static void handleHitOption(int letterIndex) {
        letters.get(letterIndex).setClicked(true);
        letters.get(letterIndex).setStyle(LetterStylesService.hit);
    }

    public static void handleNoHitOption(int letterIndex) {
        letters.get(letterIndex).setClicked(true);
        letters.get(letterIndex).setStyle(LetterStylesService.notHit);
    }
}
