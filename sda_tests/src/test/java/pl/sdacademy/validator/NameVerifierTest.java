package pl.sdacademy.validator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameVerifierTest {

    private NameVerifier nameVerifier;

    @BeforeAll
    static void beforeAll() {
        System.out.println("In before all method...");
    }

    @BeforeEach
    void beforeEach() {
        this.nameVerifier = new NameVerifier();
    }

    @Test
    void shouldValidateName() {
        // given
        String name = "Bartosz";
//        NameVerifier nameVerifier = new NameVerifier();

        // when
        boolean actualResult = nameVerifier.isNameValid(name);

        // then
        assertTrue(actualResult);
    }

    @Test
    void shouldNotValidateNameWhenAllLettersAreLowercase() {
        // given
        String name = "bartosz";
//        NameVerifier nameVerifier = new NameVerifier();

        // when
        boolean actualResult = nameVerifier.isNameValid(name);

        // then
        assertFalse(actualResult);
    }

    @Test
    void shouldNotValidateEmptyName() {
        // given
        String name = "";
//        NameVerifier nameVerifier = new NameVerifier();

        // when
        boolean actualResult = nameVerifier.isNameValid(name);

        // then
        assertFalse(actualResult);
    }

    @Test
    void shouldNotValidateNullableName() {
        // given
        String name = null;
//        NameVerifier nameVerifier = new NameVerifier();

        // when
        boolean actualResult = nameVerifier.isNameValid(name);

        // then
        assertFalse(actualResult);
    }
}