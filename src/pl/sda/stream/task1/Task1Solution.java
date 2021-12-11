package pl.sda.stream.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task1Solution {

    public static void main(String[] args) {
        List<String> list = List.of("pen", "desk", "coin", "chair");
        String any = list.stream().findAny().orElse("unknown");
        System.out.println("any = " + any);

        long count = list.stream().count();
        System.out.println("size = " + count);

//        String day = "Sunday";
//        char[] chars = day.toCharArray();
//        String[] strings = new String[chars.length];
//        int i = 0;
//        for (char element : chars) {
//            strings[i++] = new String(new char[]{element});
//        }
//
//        String value = Arrays.stream(strings)
//                .filter(element -> !element.equals("n"))
//                .collect(Collectors.joining());
//        System.out.println(value);

        String day = "Sunday";

        IntStream chars = day.chars();
        Stream<Character> stream2 = chars.mapToObj(i->(char)i);
        stream2.filter(p -> !p.equals('n')).forEach(System.out::println);
    }
}
