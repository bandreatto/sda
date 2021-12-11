package pl.sda.stream.examples;

import java.util.List;
import java.util.stream.Stream;

public class FlatMapDemo {

    public static void main(String[] args) {
        Statistics statistics1 = new Statistics(2.0, List.of(1, 2, 3));
        Statistics statistics2 = new Statistics(2.5, List.of(2, 3, 2, 3));

        Stream<Statistics> stream = Stream.of(statistics1, statistics2);
        Stream<Integer> integerStream = stream.flatMap(statistics -> statistics.getValues().stream());
        integerStream.forEach(statistics -> System.out.println(statistics));

        Stream.of(statistics1, statistics2)
                .flatMap(statistics -> statistics.getValues().stream())
                .forEach(System.out::println);

        System.out.println("---------------------");

        integerStream.forEach(statistics -> System.out.println("!" + statistics + "!"));

//        stream = Stream.of(statistics1, statistics2);
//        Stream<List<Integer>> listStream = stream.map(statistics -> statistics.getValues());
//        listStream.forEach(System.out::println);

//        Stream<Stream<Integer>> streamStream = stream.map(statistics -> statistics.getValues().stream());
    }
}
