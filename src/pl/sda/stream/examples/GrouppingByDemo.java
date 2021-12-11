package pl.sda.stream.examples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrouppingByDemo {

    public static void main(String[] args) {
        Map<Integer, List<String>> map = Stream.of("This", "is", "best", "course", "in", "SDA")
                .collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }
}
