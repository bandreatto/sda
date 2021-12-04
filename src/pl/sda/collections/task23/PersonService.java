package pl.sda.collections.task23;

import java.util.*;

public class PersonService {

    public static void main(String[] args) {
        // ZADANIE 2
//        List<Person> people = new ArrayList<>();
//        people.add(new Person("name1", "surname1", 23));
//        people.add(new Person("name2", "surname2", 54));
//        people.add(new Person("name3", "surname3", 78));
//        people.add(new Person("name4", "surname4", 12));
//
//        people.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });
//
//        for (Person person : people) {
//            System.out.println(person);
//        }
//
//        people.remove(1);
//        System.out.println("---------");
//
//        for (Person person : people) {
//            System.out.println(person);
//        }

        // ZADANIE 3
        Map<Integer, Person> map = new HashMap<>();
        Person person1 = new Person(1, "name1", "surname1", 23);
        Person person2 = new Person(10, "name2", "surname2", 54);
        Person person3 = new Person(11, "name3", "surname3", 78);
        Person person4 = new Person(7, "name4", "surname4", 12);

        map.put(person1.getId(), person1);
        map.put(person2.getId(), person2);
        map.put(person3.getId(), person3);
        map.put(person4.getId(), person4);

        Person person5 = new Person(11, "name3", "surname3", 78);

        System.out.println(map.containsKey(person5.getId()));
        System.out.println(map.containsValue(person5));
    }
}
