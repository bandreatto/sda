package pl.sda.functional.examples.common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PersonService {

    static void showEmployee(List<Person> people, Function<Person, String> function) {
        for (Person person : people) {
            String string = function.apply(person);
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("Edward");
        Person person2 = new Person("Marcin");

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);

//        showEmployee(people, person -> person.getName());
        showEmployee(people, Person::getName);
    }
}
