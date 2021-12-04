package pl.sda.collections.task8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NameService {

    private static final Map<String, Integer> CACHE = new HashMap<>();

    public int countUniqueLetters(String name) {
        if (CACHE.containsKey(name)) {
            System.out.println("Result in cache...");
            return CACHE.get(name);
        } else {
            System.out.println("Counting...");

            // 1
            char[] chars = name.toCharArray();
            // 2
            Set<Character> uniqueChars = new HashSet<>();
            // 3
            for (char tmpChar : chars) {
                uniqueChars.add(tmpChar);
            }
            // 4
            int size = uniqueChars.size();
            CACHE.put(name, size);

            return size;
        }
    }

    public static void main(String[] args) {
        NameService nameService = new NameService();
        System.out.println(nameService.countUniqueLetters("ala"));
        System.out.println(nameService.countUniqueLetters("piesek"));
        System.out.println(nameService.countUniqueLetters("ala"));
        System.out.println(nameService.countUniqueLetters("ala"));
        System.out.println(nameService.countUniqueLetters("kot"));
    }
}
