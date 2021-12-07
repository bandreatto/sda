package pl.sda.functional.examples.common;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> predicate = p -> p >= 0;
        checkTest(predicate, 5);
        checkTest(predicate, 0);
        checkTest(predicate, -100);
    }

    static void checkTest(Predicate<Integer> predicate, int parameter) {
        boolean booleanValue = predicate.test(parameter);
        System.out.println(booleanValue);
    }
}
