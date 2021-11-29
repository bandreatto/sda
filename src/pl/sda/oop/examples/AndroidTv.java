package pl.sda.oop.examples;

public class AndroidTv {

    public static void main(String[] args) {
        final String player = "HboGo";
        VodPlayer vodPlayer = null;
        if (player.equals("Netflix")) {
            vodPlayer = new NetflixPlayer();
        } else if (player.equals("HboGo")) {
            vodPlayer = new HboGoPlayer();
        } else {
            vodPlayer = new DefaultPlayer();
        }
        //

        playEpisode(vodPlayer, "sample title...");
    }

    static void playEpisode(VodPlayer player, String title) {
        player.play(title);
    }
}
