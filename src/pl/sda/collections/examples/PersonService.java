package pl.sda.collections.examples;

import java.util.HashSet;
import java.util.Set;

public class PersonService {

    public static void main(String[] args) {
        Person person1 = new Person(1, "Bartosz", "Drugi");
        Person person2 = new Person(2, "Kazimierz", "Trzeci");
        Person person3 = new Person(3, "Karolina", "Pierwsza");

        Set<Person> people = new HashSet<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);

        for (Person person : people) {
            System.out.println(person);
        }

        Person person4 = new Person(2, "Kazimierz", "Trzeci");
        System.out.println(person2.equals(person4));
        System.out.println("---------------");

        System.out.println("person2 hashcode = " + person2.hashCode());
        System.out.println("person4 hashcode = " + person4.hashCode());

        boolean contains = people.contains(person4);
        System.out.println(contains);

        System.out.println("------------------");
        Person person5 = new Person(101, "Andrzej", "Wspaniały");
        Employee employee1 = new Employee(101, "Andrzej", "Wspaniały", "12345");

        System.out.println(person5.getClass().getName());
        System.out.println(employee1.getClass().getName());

        System.out.println(person5.equals(employee1));
    }
}
