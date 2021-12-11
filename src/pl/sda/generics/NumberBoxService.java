package pl.sda.generics;

public class NumberBoxService {

    public static void main(String[] args) {
        NumberBox<Integer> intBox = new NumberBox<>(5);
        System.out.println(intBox.getValue());

        NumberBox<Double> doubleBox = new NumberBox<>(4.67);
    }
}
