package pl.sda.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementingThread implements Runnable {

    private final AtomicInteger value;

    public IncrementingThread(AtomicInteger value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
             value.incrementAndGet();
        }

        System.out.println("value = " + value);
    }
}
