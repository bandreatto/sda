package pl.sda.stream.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedDemo {

    public static void main(String[] args) {
        Arrays.asList(6, 3, 6, 21, 20, 1).stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("--------");

        List<Person> people = List.of(new Person("Bartosz", 11),
                new Person("Karolina", 9),
                new Person("Daniel", 13),
                new Person("Witold", 10));
        people.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------");

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
