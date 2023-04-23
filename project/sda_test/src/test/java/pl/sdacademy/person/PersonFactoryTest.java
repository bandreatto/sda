package pl.sdacademy.person;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonFactoryTest {

    private PersonFactory personFactory;

    @BeforeAll
    static void beforeAll() {
        System.out.println("In before all...");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("In after all...");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("In before each...");
        personFactory = new PersonFactory();
    }

    @AfterEach
    void afterEach() {
        System.out.println("In after each...");
    }

    @Test
    void shouldCreateMalePerson() {
        // given
        String name = "Andrzej";
        String surname = "Kowalski";
        String expectedPrefix = "Mr";

        // when
        Person actualPerson = personFactory.createPerson(name, surname);

        // then
        assertNotNull(actualPerson);
//        assertEquals(name, actualPerson.getFirstName());
//        assertEquals(surname, actualPerson.getLastName());
//        assertEquals(expectedPrefix, actualPerson.getPrefix());

        assertAll(
                () -> assertEquals(name, actualPerson.getFirstName()),
                () -> assertEquals(surname, actualPerson.getLastName()),
                () -> assertEquals(expectedPrefix, actualPerson.getPrefix())
        );
    }

    @Test
    void shouldCreateFemalePerson() {
        // given
        String name = "Karolina";
        String surname = "Kowalska";
        String expectedPrefix = "Ms";

        // when
        Person actualPerson = personFactory.createPerson(name, surname);

        // then
        org.assertj.core.api.Assertions.assertThat(actualPerson)
                .isNotNull() // sprawdzamy obiekt person nie jest null'em
                .extracting(p -> p.getPrefix()) // p reprezentuje actualPerson (wyrażenie lambda)
                .isNotNull() // sprawdzamy czy prefix nie jest null'em
                .isEqualTo(expectedPrefix); // sprawdzamy czy prefix jest równy expectedPrefix

//        org.assertj.core.api.Assertions.assertThat(actualPerson.getLastName())
//                .isEqualTo(surname);
    }
}