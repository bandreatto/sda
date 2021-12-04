package pl.sda.collections.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListService {

    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("Andrzej");
        names.add("Andrzej");
        names.add("Andrzej");
        names.add("Wociech");
        names.add("Grzegorz");
        names.add(null);

        names.add(2, "Karolina");

//        for (int i = 0; i < names.size(); i++) {
//            System.out.println(names.get(i));
//        }


        for (String name : names) {
            System.out.println(name);
        }

//        for (String name : names) {
//            System.out.println(name);
//        }
    }
}
