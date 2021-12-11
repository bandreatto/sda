package pl.sda.stream.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterDemo {

    public static void main(String[] args) {
//        final int[] idx = {0};
//        Stream.generate(() -> idx[0]++)
//                .limit(10)
//                .filter(element -> element % 2 == 0)
//                .forEach(System.out::println);

        System.out.println("------------------");
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        list.stream()
                .limit(10)
                .filter(element -> element % 2 == 0)
                .forEach(System.out::println);

        System.out.println(list);
    }
}
