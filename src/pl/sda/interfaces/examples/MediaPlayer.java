package pl.sda.interfaces.examples;

public interface MediaPlayer {

//    public static final String NAME = "unknown";
    String NAME = "unknown";

//    public abstract void play();
    void play();

//    public abstract void stop();
    void stop();

    default int next() {
        return 1;
    }

//    public static void main(String[] args)
    static void main(String[] args) {
        System.out.println("in main...");
    }
}
