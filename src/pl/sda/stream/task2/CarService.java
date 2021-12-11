package pl.sda.stream.task2;

import java.util.Comparator;
import java.util.List;

public class CarService {

    public static void main(String[] args) {
        List<Car> list = List.of(new Car("1", 100), new Car("2b", 50), new Car("1b", 70));
        list.stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .forEach(System.out::println);
    }
}
