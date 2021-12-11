package pl.sda.thread;

public class HelloWorldThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello world from another Thread");
        Thread currentThread = Thread.currentThread();
        long currentThreadId = currentThread.getId();
        System.out.println("id = " + currentThreadId);
    }
}
