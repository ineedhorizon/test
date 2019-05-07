package ru.youla.interview;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainApp {

    private static final ScheduledExecutorService personProducer = Executors.newSingleThreadScheduledExecutor();
    public static final int DELAY_BETWEEN_ARRIVE_PERSON = 3;

    public static void main(String[] args) {
        Club nightClub = new NightClub(new RandomDJ());

        personProducer.scheduleWithFixedDelay(
                () -> nightClub.arrivePerson(new RandomPerson()),
                0,
                DELAY_BETWEEN_ARRIVE_PERSON,
                TimeUnit.SECONDS);
    }
}
