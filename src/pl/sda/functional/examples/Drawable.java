package pl.sda.functional.examples;

public interface Drawable {

    default void executor(int x, int y) {
        System.out.println("In default method of Drawable: "
                + "x = " + x + ", y = " + y);
    }
}
