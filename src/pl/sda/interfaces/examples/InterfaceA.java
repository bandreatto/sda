package pl.sda.interfaces.examples;

public interface InterfaceA {

    default void sampleDefaultMethod() {
        System.out.println("In A...");
    }
}
