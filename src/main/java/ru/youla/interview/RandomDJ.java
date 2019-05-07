package ru.youla.interview;

public class RandomDJ implements DJ {

    @Override
    public Music playMusic() {
        return Music.getRandom();
    }
}
