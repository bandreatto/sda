package pl.sda.functional.examples.optional;

import java.util.Optional;

public class OptionalService {

    public Integer getAge(String name) {
        if (name.equalsIgnoreCase("piotr")) {
            return 23;
        }

        return null;
    }

    public Optional<Integer> getPossibleAge(String name) {
        if (name.equalsIgnoreCase("piotr")) {
            return Optional.of(33);
        }

        // pudełko
        return Optional.empty();
    }

    public Integer getDefaultAge() {
        System.out.println("I am in getDefaultAge method...");
        int k = 10;
        for (int i = 0; i < 10000000; i++) {
            k++;
            k--;
        }

        return 100;
    }

    public static void main(String[] args) {
        OptionalService optionalService = new OptionalService();

        // 1
        Integer age = optionalService.getAge("marta");
        if (age != null) {
            int newValue = age * age;
            if (newValue > 600) {
                System.out.println(newValue);
            }
        }

        System.out.println("!!!!!!!!!!!!!!!!!");

        // 2
        Optional<Integer> possibleAge1 = optionalService.getPossibleAge("marta");
        if (possibleAge1.isPresent()) { // !possibleAge1.isEmpty()
            Integer extractedAge = possibleAge1.get();
            System.out.println(extractedAge * extractedAge);
        } else {
            System.out.println("Optional is empty!!!");
        }

        System.out.println("!!!!!!!!!!!!!!!!!");

        // 3
//        Optional<Integer> possibleAge2 = optionalService.getPossibleAge("piotr");
//        Optional<Integer> tmpAge = possibleAge2.map(p -> p * p);
//        tmpAge.ifPresent(t -> System.out.println(t));

//        optionalService.getPossibleAge("marta")
//                .map(p -> p * p).ifPresent(System.out::println);

//        optionalService.getPossibleAge("marta")
//                .map(p -> p * p).ifPresentOrElse(System.out::println,
//                        () -> System.out.println("Optional is empty!!!"));

        optionalService.getPossibleAge("piotr")
                .map(p -> p * p)
                .filter(p -> p > 600)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Optional is empty!!!"));

        // 4
        String value = null;

        Optional<String> possibleValue;
        possibleValue = Optional.ofNullable(value);
//        if (value != null) {
//            possibleValue = Optional.of(value);
//        } else {
//            possibleValue = Optional.empty();
//        }

        // 5
//        Optional<Integer> optional2 = optionalService.getPossibleAge("kazimierz");
//        if (optional2.isPresent()) {
//            System.out.println(optional2.get());
//        } else {
//            System.out.println(100);
//        }

//        Optional<Integer> optional2 = optionalService.getPossibleAge("kazimierz");
//        Integer age2 = optional2.orElse(100);
//        System.out.println(age2);

        Optional<Integer> optional2 = optionalService.getPossibleAge("piotr");
        Integer age2 = optional2.orElse(optionalService.getDefaultAge());
        System.out.println(age2);

        System.out.println("@@@@");

        Optional<Integer> optional3 = optionalService.getPossibleAge("piotr");
        Integer age3 = optional3.orElseGet(optionalService::getDefaultAge);
        System.out.println(age3);

    }
}
