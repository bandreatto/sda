package pl.sda.stream.examples;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ParallelDemo {

    public static void main(String[] args) {
        // 1 Metoda parallelStream na kolekcji
        List<Integer> list = List.of(2, 4, 6, 1, 3, 9, 8, 0);
        list.stream().forEach(System.out::println);
        System.out.println("-------");
        list.parallelStream().forEach(System.out::println);
        System.out.println("@@@@@@@@");
        list.stream().findAny().ifPresent(System.out::println);
        list.parallelStream().findAny().ifPresent(System.out::println);
        System.out.println("$$$$$$$$");
        list.stream().findFirst().ifPresent(System.out::println);
        list.parallelStream().findFirst().ifPresent(System.out::println);

        // 3 parallel na istniejącym strumieniu
        System.out.println("---------");
        Stream.of(1, 2, 3, 6, 7).parallel().forEach(System.out::println);
    }
}
