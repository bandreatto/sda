package pl.sda.patterns.observer;

public class UserObserver extends BaseObserver {

    private final String userName;

    public UserObserver(ChatChannel chatChannel, String userName) {
        super(chatChannel);
        this.userName = userName;
        System.out.println(userName + " is joining " + chatChannel.getName());
    }

    @Override
    public void handleMessage(String message, String userType) {
        if (!"ADMIN".equalsIgnoreCase(userType)) {
            System.out.println(userName + " reads message " + message);
        }
    }

    @Override
    public String getObserverType() {
        return "USER";
    }
}
