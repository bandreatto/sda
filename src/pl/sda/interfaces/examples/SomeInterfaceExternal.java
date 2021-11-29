package pl.sda.interfaces.examples;

public interface SomeInterfaceExternal {

    void someMethod();

    default void someDefaultMethod() {
        System.out.println("In some default method...");
    }
}
