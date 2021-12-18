package pl.sda.patterns.observer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ChatChannel {

    @Getter
    private final String name;

    private final List<BaseObserver> observers = new ArrayList<>();
    private final List<String> messages = new ArrayList<>();

    public void subscribe(BaseObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void sendMessage(String message, String observerType) {
        messages.add(message);
        notifyAll(message, observerType);
    }

    private void notifyAll(String message, String observerType) {
        observers.forEach(observer -> {
            observer.handleMessage(message, observerType);
        });
    }
}
