package pl.sda.oop.examples;

public class HboGoPlayer extends VodPlayer {

    @Override
    public void play(String title) {
        System.out.println("Playing " + title + "on HBO GO");
    }
}
