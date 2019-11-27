package com.hangman;

import java.util.ArrayList;
import java.util.List;

public class Handler {
    public static String password;
    public static String hiddenPassword;
    public static int mistakesNumber;
    public static List<Letter> letters;
    public static Integer numberOfImg;

    static {
        password = PasswordService.getRandomPassword().toUpperCase();
        hiddenPassword = PasswordService.hidePassword(password);
        mistakesNumber = 0;
        letters = generateAlphabet();
        numberOfImg = 0;
    }

    private static List<Letter> generateAlphabet() {
        List<Letter> letters = new ArrayList<>();
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            letters.add(new Letter(letter + ""));
        }
        return letters;
    }


    public static boolean checkTheLetter(int letterIndex) {
        return password.contains(letters.get(letterIndex).getSymbol());
    }

    public static List<String> getLettersSymbols() {
        List<String> symbols = new ArrayList();
        for (Letter letter : letters) {
            symbols.add(letter.getSymbol());
        }
        return symbols;
    }

    public static void handleHitOption(int letterIndex) {
            letters.get(letterIndex).setClicked(true);
            letters.get(letterIndex).setStyle(LetterStylesService.hit);
            String symbol = letters.get(letterIndex).getSymbol();
            List<Integer> hiddenIndexes = findIndexes(symbol);
            updateHiddenPassword(hiddenIndexes, symbol);
    }

    private static void updateHiddenPassword(List<Integer> hiddenIndexes, String symbol) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hiddenPassword.length(); i++) {
            if (hiddenIndexes.contains(i)) {
                sb.append(symbol);
            } else {
                sb.append(hiddenPassword.charAt(i) + "");
            }
        }
        hiddenPassword = sb.toString();
    }

    private static List<Integer> findIndexes(String symbol) {
        List<Integer> hiddenIndexes = new ArrayList<>();
        for (int index = 0; index < password.length(); index++) {
            if (symbol.equals(password.charAt(index) + "")) {
                hiddenIndexes.add(index);
            }
        }
        return hiddenIndexes;
    }

    public static void handleNoHitOption(int letterIndex) {
        letters.get(letterIndex).setClicked(true);
        letters.get(letterIndex).setStyle(LetterStylesService.notHit);
        mistakesNumber++;
    }

    public static boolean checkWin() {
        return hiddenPassword.equals(password);
    }

    public static boolean checkLose() {
        return mistakesNumber > 9;
    }
}
