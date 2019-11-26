package com.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PasswordService {
    public List<String> passwords;
    private Random random;

    {
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

    public String getRandomPassword() {
        int index = random.nextInt(passwords.size());
        return passwords.get(index);
    }

}
