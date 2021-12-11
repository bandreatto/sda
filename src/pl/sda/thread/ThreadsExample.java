package pl.sda.thread;

public class ThreadsExample {

    public static void main(String[] args) {
        HelloWorldThread myThread = new HelloWorldThread();
        myThread.start();
        System.out.println("In main: " + Thread.currentThread().getId());
    }
}
