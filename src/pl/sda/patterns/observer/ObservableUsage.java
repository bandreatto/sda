package pl.sda.patterns.observer;

public class ObservableUsage {

    public static void main(String[] args) {
        ChatChannel chatChannel = new ChatChannel("zdjavapol110");
        BaseObserver kursant1 = new UserObserver(chatChannel, "kursant1");
        BaseObserver kursant2 = new UserObserver(chatChannel, "kursant2");

        BaseObserver admin1 = new AdminObserver(chatChannel, "admin1");
        BaseObserver admin2 = new AdminObserver(chatChannel, "admin2");

        kursant1.sendMessage("'Wiadomosc 1 od kursanta 1'");
        kursant2.sendMessage("'Jestem'");
        kursant2.sendMessage("'drugim kursantem'");

        admin1.sendMessage("'powiadomienie admina1'");
        admin2.sendMessage("'powiadomienie admina2'");
    }
}
