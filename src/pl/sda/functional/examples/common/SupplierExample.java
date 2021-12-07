package pl.sda.functional.examples.common;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
//        printValue(() -> 5);
        Random random = new Random();
//        printValue(() -> random.nextInt());
        printValue(random::nextInt);
    }

    static void printValue(Supplier<Integer> intSupplier) {
        Integer intValue = intSupplier.get();
        System.out.println(intValue);
    }
}
