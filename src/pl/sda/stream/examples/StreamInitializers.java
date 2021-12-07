package pl.sda.stream.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamInitializers {

    public static void main(String[] args) {
        // 1. Tworzymy strumień na podstawie kolekcji
        List<String> names = new ArrayList<>();
        names.add("Bartosz");
        names.add("Anna");
        names.add("Karol");

        Stream<String> stream1 = names.stream();

        // 2. Tworzymy strumień na podstawie tablicy
        String[] items = new String[]{"item1", "item2", "item3"};
        Stream<String> stream2 = Arrays.stream(items);

        // 3. Wykorzystujemy metode of
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 5, 7, 11, 17);

        // 4. Wykorzystujemy metode generate
        Stream<Integer> stream4 = Stream.generate(() -> {
            Random random = new Random();
            return random.nextInt(10);
        });

        //---------- Terminal operations --------------
//        stream3.forEach(System.out::println);
        stream3.map(element -> {
            System.out.println("I am in map... element = " + element);
            return element * 3;
        }).forEach(System.out::println);
    }
}
