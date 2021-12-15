package pl.sda.thread;

public class SleepingThreadsExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepingThread());
        thread.start();
        Thread.sleep(2000L);
        thread.interrupt();
        System.out.println("In main...: " + Thread.currentThread().getId());
    }
}
