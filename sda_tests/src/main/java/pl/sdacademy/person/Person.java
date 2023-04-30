package pl.sdacademy.person;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
class Person {

    private String prefix;
    private String firstName;
    private String lastName;
}
