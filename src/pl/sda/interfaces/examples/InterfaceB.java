package pl.sda.interfaces.examples;

public interface InterfaceB {

    default void sampleDefaultMethod() {
        System.out.println("In B...");
    }
}
