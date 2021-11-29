package pl.sda.oop.examples;

public class NetflixPlayer extends VodPlayer {

    @Override
    public void play(String title) {
        System.out.println("Playing " + title + "on Netlifx");
    }
}
