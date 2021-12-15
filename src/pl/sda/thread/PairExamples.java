package pl.sda.thread;

public class PairExamples {

    public static void main(String[] args) {
        Pair pair = new Pair(0, 0);
        Thread thread1 = new Thread(new DummyPairIncrementer(pair));
        Thread thread2 = new Thread(new DummyPairIncrementer(pair));

        thread1.start();
        thread2.start();
    }
}
