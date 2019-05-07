package ru.youla.interview;

import java.security.SecureRandom;
import java.util.Random;

public enum Music {

    ELECTRO,
    POP,
    DnB,
    RnB;

    private static final Random rnd = new SecureRandom();

    public static Music getRandom() {
        return values()[rnd.nextInt(values().length)];
    }
}
