package ru.youla.interview;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NightClub implements Club {

    private static final int DELAY_BETWEEN_MUSIC_CHANGE = 5;
    private static final String NOW_PLAYING_TEXT = "Сейчас играет ";

    private DJ dj;
    private ConcurrentLinkedQueue<Person> visitors;
    private ScheduledExecutorService musicChanger;

    public NightClub(DJ dj) {
        this.dj = dj;
        visitors = new ConcurrentLinkedQueue<>();

        musicChanger = Executors.newSingleThreadScheduledExecutor();
        musicChanger.scheduleWithFixedDelay(
                this::changeMusic,
                0,
                DELAY_BETWEEN_MUSIC_CHANGE,
                TimeUnit.SECONDS);
    }

    @Override
    public void changeMusic() {
        Music playingNow = dj.playMusic();

        System.out.println(NOW_PLAYING_TEXT + playingNow);

        for (Person p : visitors) {
            p.makeDecision(playingNow);
        }
    }

    @Override
    public void arrivePerson(Person p) {
        visitors.add(p);
    }
}
