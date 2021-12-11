package pl.sda.stream.examples;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

    public static void main(String[] args) {
//        List<Integer> list = Stream.generate(() -> {
//                    Random random = new Random();
//                    return random.nextInt(10);
//                }).limit(10)
//                .distinct()
//                .peek(element -> System.out.println("@" + element + "@"))
//                .filter(element -> element % 2 == 0)
//                .peek(element -> System.out.println("!" + element + "!"))
//                .collect(Collectors.toList());
//        System.out.println(list);

        System.out.println("----------------");

//        String sentence = Stream.of("This", "will", "be", "single", "sentence", "and", "...", "?")
//                .filter(word -> word.length() > 3)
//                .collect(Collectors.joining(", "));
//        System.out.println(sentence);
//
//        String sentence = Stream.of("This", "will", "be", "single", "sentence", "and", "...", "?")
//                .filter(word -> word.length() > 3)
//                .collect(Collectors.joining(", ", "[", "]"));
//        System.out.println(sentence);

        System.out.println("---------------");

        // Map<String, String>
        // Hello -> HELLO
        // from -> FROM
        // Stettin -> STETTIN

//        Map<String, String> map = Stream.of("Hello", "from", "Stettin")
//                .collect(Collectors.toMap(word -> word, word -> word.toUpperCase()));
        Map<String, String> map = Stream.of("Hello", "from", "Stettin")
                .collect(Collectors.toMap(word -> word, String::toUpperCase));
        System.out.println(map);
    }
}
