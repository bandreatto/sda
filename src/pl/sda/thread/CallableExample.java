package pl.sda.thread;

import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "I am result of call...";
            }
        });

        try {
            String result = future.get();
            System.out.println("Result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            System.out.println("Oooopssss....");
        }

        executorService.shutdown();
    }
}
