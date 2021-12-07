package pl.sda.functional.task12;

import java.util.List;
import java.util.function.Consumer;

public class CollectionService {

    public static void main(String[] args) {
        List<String> names = List.of("Marian", "Marianna", "Klaudia");
        Consumer<String> consumer = System.out::println;
        names.forEach(consumer);

//        names.forEach(n -> System.out.println(n));
//        names.forEach(System.out::println);
    }
}
