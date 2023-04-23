package pl.sdacademy.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
class Person {

    private String prefix;
    private String firstName;
    private String lastName;
}
