package pl.sda.anonymous.examples;

public class UiComponents {

    public static void main(String[] args) {
        final int x = 5;

        ClickListener object = new ClickListener() {

            @Override
            public void onClick() {
                System.out.println("Clicked me!!! " + x);
            }
        };

        object.onClick();
    }
}
