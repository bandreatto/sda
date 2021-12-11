package pl.sda.stream.examples;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

public class FindFirstDemo {

    public static void main(String[] args) {
        List<String> list = List.of("kto", "będzie", "pierwszym", "elementem");
//        List<String> collectedList = list.stream()
//                .sorted()
//                .filter(element -> !element.startsWith("b"))
//                .limit(1)
//                .collect(Collectors.toList());
//
//        System.out.println(collectedList);
//
//        if (collectedList.size() > 0) {
//            System.out.println(collectedList.get(0));
//        }

        Optional<String> possibleElement = list.stream()
                .sorted()
                .filter(element -> !element.startsWith("b"))
                .findFirst();

        possibleElement.ifPresent(System.out::println);

        possibleElement = list.stream()
                .sorted()
                .filter(element -> !element.startsWith("b"))
                .findAny();

        possibleElement.ifPresent(System.out::println);
    }
}
