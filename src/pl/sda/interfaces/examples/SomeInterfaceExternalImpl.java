package pl.sda.interfaces.examples;

public class SomeInterfaceExternalImpl implements SomeInterfaceExternal {

    @Override
    public void someMethod() {
        System.out.println("Some method implementation...");
//        someDefaultMethod();
    }

    @Override
    public void someDefaultMethod() {
//        SomeInterface.super.someDefaultMethod();
        System.out.println("In default method in some interface implementation");
    }

    public static void main(String[] args) {
//        Object object = "Lancuch znakow";
        SomeInterfaceExternal someInterface = new SomeInterfaceExternalImpl();
        someInterface.someMethod();
        someInterface.someDefaultMethod();
    }
}
