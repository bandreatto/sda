package pl.sda.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LowerBoundedWildcards {

    public static void addNumbers(List<? super Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println("-----------");
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        addNumbers(list);

//        List<Integer> list = List.of(1, 2, 3);
//        list.remove(0); // exception - lista bez mozliwosci modyfikacji
//        addNumbers(list); // exception - lista bez mozliwosci modyfikacji

        List<Object> objectList = new ArrayList<>();
        objectList.add(1);
        objectList.add("ball");
        objectList.add(new Date());

        addNumbers(objectList);
    }
}
