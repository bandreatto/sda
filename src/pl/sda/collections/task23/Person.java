package pl.sda.collections.task23;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Person {

    @Getter
    private Integer id;

    private String name;

    private String surname;

    @Getter
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
