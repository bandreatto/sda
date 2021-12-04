package pl.sda.collections.examples;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User implements Comparable<User> {

    private String name;

    private int age;

    @Override
    public int compareTo(User o) {
        return age - o.age;

//        if (age < o.age) {
//            return -5;
//        }
//
//        if (age > o.age) {
//            return 100;
//        }
//
//        return 0;
    }
}
