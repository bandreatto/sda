package pl.sda.thread;

public class DummyPairIncrementer implements Runnable {

    private final Pair pair;

    public DummyPairIncrementer(Pair pair) {
        this.pair = pair;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            pair.incrementLeft();
            pair.incrementRight();
        }

        System.out.println(pair.getLeft() + " - " + pair.getRight());
    }
}
