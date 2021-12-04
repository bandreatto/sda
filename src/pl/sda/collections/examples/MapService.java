package pl.sda.collections.examples;

import com.sun.source.tree.Tree;

import java.util.*;

public class MapService {

    public static void main(String[] args) {
//        Map<Integer, String> ageToNames = new HashMap<>();
//        ageToNames.put(11, "Andrzej");
//        ageToNames.put(22, "Michał");
//        ageToNames.remove(22);
//        System.out.println(ageToNames.get(11));

        Map<Integer, String> ageToNames = new HashMap<>();
        ageToNames.put(20, "Gosia");
        ageToNames.put(40, "Kasia");
        ageToNames.put(30, "Ania");

        Set<Integer> keys = ageToNames.keySet();
        for (Integer key : keys) {
            System.out.println("Key = " + key);
        }

        System.out.println("---------------");

        Collection<String> values = ageToNames.values();
        for (String value : values) {
            System.out.println("value = " + value);
        }

        System.out.println("---------------");

        Set<Map.Entry<Integer, String>> entries = ageToNames.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        System.out.println("---------------");

        Map<Integer, Integer> numbers = new TreeMap<>();
        numbers.put(2, 3);
        numbers.put(1, 0);
        numbers.put(5, 4);

        numbers.forEach((key, value) -> System.out.println(key + " " + value));

    }
}
