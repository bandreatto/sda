package pl.sda.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsExample {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("available processors = " + availableProcessors);
        ExecutorService executorService1 = Executors.newFixedThreadPool(availableProcessors);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
    }
}
