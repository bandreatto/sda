package pl.sda.generics;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildcards {

    public static double sum(List<? extends Number> list) {
        double sum = 0.0;
        for (Number number : list) {
            sum += number.doubleValue();
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        System.out.println(sum(intList));

        List<Double> doubleList = List.of(2.0, 3.0, 4.5);
        System.out.println(sum(doubleList));


//        List<? extends Number> mixedList = new ArrayList<>();
//
    }
}
