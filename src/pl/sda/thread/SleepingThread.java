package pl.sda.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SleepingThread implements Runnable {

    @Override
    public void run() {
        List<Integer> list = new ArrayList<>(); // List.of();
        for (int i = 0; i < 1000; i++) {
            list.add(new Random().nextInt(10));
        }

        Thread currentThread = Thread.currentThread();
        if (currentThread.isInterrupted()) {
            System.out.println("I was interrupeted (" + currentThread.getId() + ")");
            return;
        }

        // wyznaczamy sume
        // IntStream
//        int sum = list.stream().mapToInt(value -> value).sum();
//        Integer sum = list.stream().reduce(0, (s, e) -> s + e);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println("Sum is: " + sum);
    }
}
