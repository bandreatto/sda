package pl.sdacademy.person;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonFactoryTest {

    @Test
    @DisplayName("Should create female person with expected 'Ms' prefix")
    void shouldCreateFemalePerson() {
        // given
        PersonFactory personFactory = new PersonFactory();
        String firstName = "Karolina";
        String lastName = "Kowalska";
        Person expectedPerson = new Person("Ms", firstName, lastName);

        // when
        Person actualPerson = personFactory.createPerson(firstName, lastName);

        // then
        assertNotNull(actualPerson);
        assertNotSame(expectedPerson, actualPerson);
//        assertEquals(expectedPerson, actualPerson); // alternatywne rozwiązanie
        assertAll(
                () -> assertEquals("Ms", actualPerson.getPrefix()),
                () -> assertEquals(firstName, actualPerson.getFirstName()),
                () -> assertEquals(lastName, actualPerson.getLastName())
        );
    }

    @Test
//    @Disabled
    void shouldCreateMalePerson() {
        // given
        PersonFactory personFactory = new PersonFactory();
        String firstName = "Bartosz";
        String lastName = "Andreatto";
        Person expectedPerson = new Person("Mr", firstName, lastName);

        // when
        Person actualPerson = personFactory.createPerson(firstName, lastName);

        // then
        assertNotNull(actualPerson);
//        assertEquals(expectedPerson, actualPerson); // alternatywne rozwiązanie
        assertAll(
                () -> assertEquals("Mr", actualPerson.getPrefix()),
                () -> assertEquals(firstName, actualPerson.getFirstName()),
                () -> assertEquals(lastName, actualPerson.getLastName())
        );

        // Wykorzystanie (demonstracja) użycia biblioteki AssertJ
        Assertions.assertThat(actualPerson)
                .isNotNull() // sprawdzamy czy obiekt 'actualPerson' nie jest nullem
                .extracting(p -> p.getPrefix()) // to samo co: Person::getPrefix (wyrażenie lambda)
                .isNotNull() // sprawdzamy czy 'prefix' nie jest nullem
                .isEqualTo("Mr"); // sprawdzamy czy 'prefix' równa się 'Mr'
    }
}