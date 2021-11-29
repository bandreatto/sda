package pl.sda.oop.examples;

public class DefaultPlayer extends VodPlayer {

    @Override
    public void play(String title) {
        System.out.println("Playing " + title + "on default player");
    }
}
