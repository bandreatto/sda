package pl.sda.collections.examples;

import java.util.*;
import java.util.function.DoubleBinaryOperator;

public class SetService {

    public static void main(String[] args) {
//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set1 = new TreeSet<>(Comparator.reverseOrder());
        System.out.println(set1.isEmpty());
        System.out.println("----------");
        set1.add(1);
        set1.add(17);
        set1.add(3);
        set1.add(5);
        set1.add(2);
        set1.add(1);

        System.out.println(set1.size());
        System.out.println("----------");
        set1.forEach(System.out::println);

        System.out.println(set1.contains(21));

//        Object[] objects = set1.toArray();
//        for (int i = 0; i < objects.length; i++) {
//            System.out.println(objects[i]);
//        }
    }
}
