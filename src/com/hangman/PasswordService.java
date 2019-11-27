package com.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PasswordService {
    public static List<String> passwords;
    private static Random random;

    static {
        random = new Random();
        passwords = Arrays.asList("Life is too important to be taken seriously",
                "It always seems impossible until it is done",
                "My life is my message",
                "I love those who can smile in trouble",
                "Love is not necessary power is the only true necessity",
                "When a man learns to love, he must bear the risk of hatred",
                "Never give up without even trying",
                "A place where someone still thinks about you is a place you can call home",
                "Once you question your own belief it is over");
    }

    public static String getRandomPassword() {
        int index = random.nextInt(passwords.size());
        return passwords.get(index).toUpperCase();
    }

    public static String hidePassword(String password) {
        StringBuilder sb = new StringBuilder();
        for (String letter: password.split("")) {
            if (letter.equals(" ")) {
                sb.append(" ");
            } else {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
