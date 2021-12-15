package pl.sda.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExamples {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        executorService.submit(new IncrementingThread(atomicInteger));
        executorService.submit(new IncrementingThread(atomicInteger));
        executorService.shutdown();
    }
}
