package pl.sda.patterns.observer;

public abstract class BaseObserver {

    protected final ChatChannel chatChannel;

    public BaseObserver(ChatChannel chatChannel) {
        this.chatChannel = chatChannel;
        chatChannel.subscribe(this);
    }

    public abstract void handleMessage(String message, String userType);

    public abstract String getObserverType();

    public void sendMessage(String message) {
        String observerType = getObserverType();
        chatChannel.sendMessage(message, observerType);
    }
}
