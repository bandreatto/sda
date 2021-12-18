package pl.sda.patterns.observer;

public class AdminObserver extends BaseObserver {

    private final String adminName;

    public AdminObserver(ChatChannel chatChannel, String adminName) {
        super(chatChannel);
        this.adminName = adminName;
        System.out.println(adminName + " has joined " +  chatChannel.getName() + " as admin!");
    }

    @Override
    public void handleMessage(String message, String userType) {
        System.out.println(adminName + " reads " + message + " from user with type " + userType);
    }

    @Override
    public String getObserverType() {
        return "ADMIN";
    }
}
