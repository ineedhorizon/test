package ru.youla.interview;

public class RandomPerson implements Person {

    private static final String GO_TO_BAR_TEXT = "Очень плохая музыка! Пойду в бар...";
    private static final String LETS_DANCE_TEXT = "О! Мой любимый трек, я танцевать!";

    private Music music;

    public RandomPerson() {
        this.music = Music.getRandom();
    }

    @Override
    public void makeDecision(Music music) {
        if (this.music.equals(music)) {
            System.out.println(LETS_DANCE_TEXT);
        } else {
            System.out.println(GO_TO_BAR_TEXT);
        }
    }
}
