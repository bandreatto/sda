package pl.sda.functional.examples;

@FunctionalInterface
public interface Executor {

    void executor(int x);

    default void executor(int x, int y) {
        System.out.println("In default method of Executor: "
                + "x = " + x + ", y = " + y);
    }
}
