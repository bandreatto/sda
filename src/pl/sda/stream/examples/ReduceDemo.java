package pl.sda.stream.examples;

import pl.sda.lombok.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceDemo {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Bartosz", 12),
                new Person("Agnieszka", 10),
                new Person("Ewa", 11));

//        Integer ageSum = people.stream()
//                .map(person -> person.getAge())
////                .filter(age -> age >= 18)
//                .reduce(0, (sum, element) -> {
//                    System.out.println("sum = " + sum + ", element = " + element);
//                    return sum + element;
//                });
//        System.out.println(ageSum);

        System.out.println("-------------------");

        Optional<Integer> possibleAge = people.stream()
                .map(person -> person.getAge())
                .filter(age -> age >= 18)
                .reduce((element1, element2) -> element1 + element2);

        possibleAge.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Empty optional - empty stream..."));
    }
}
