package pl.sda.interfaces.examples;

public class Item implements InterfaceA, InterfaceB {

    @Override
    public void sampleDefaultMethod() {
        InterfaceB.super.sampleDefaultMethod();
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.sampleDefaultMethod();
    }
}
