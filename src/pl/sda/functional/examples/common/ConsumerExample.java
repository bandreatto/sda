package pl.sda.functional.examples.common;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> consumer = p -> {
            String newValue = p.trim();
            String lowercaseValue = newValue.toLowerCase();
            System.out.println(lowercaseValue);
        };

        trimValue(consumer, "   Pada śNIeg...     ");
    }

    static void trimValue(Consumer<String> consumer, String parametr) {
        consumer.accept(parametr);
    }
}
