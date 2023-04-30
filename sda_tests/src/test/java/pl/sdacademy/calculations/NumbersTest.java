package pl.sdacademy.calculations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.OptionalInt;
import java.util.stream.Stream;

class NumbersTest {

    private Numbers numbers;
    
    @BeforeEach
    void beforeEach() {
        this.numbers = new Numbers();
    }
    
    @Test
    void shouldFindFirstDigitInString() {
        // given
        String value = "def354fgh";
        int expectedValue = 3;

        // when
        OptionalInt possibleFirstDigit = numbers.findFirstDigit(value);

        // then
        Assertions.assertThat(possibleFirstDigit)
                .isNotNull()
                .isPresent()
                .hasValue(expectedValue);
    }

    @ParameterizedTest(name = "{index}: First digit in \"{0}\" is {1}")
    @MethodSource("provideArgsForFindFirstDigitTest")
    void shouldFindExpectedFirstDigitForGivenString(String value, int expectedDigit) {
        // given

        // when
        OptionalInt possibleFirstDigit = numbers.findFirstDigit(value);

        // then
        Assertions.assertThat(possibleFirstDigit)
                .isNotNull()
                .isPresent()
                .hasValue(expectedDigit);
    }

    @Test
    void shouldNotFindAnyDigitWhenThereAreNone() {
        // given
        String value = "abc";

        // when
        OptionalInt possibleFirstDigit = numbers.findFirstDigit(value);

        // then
        Assertions.assertThat(possibleFirstDigit)
                .isNotNull()
                .isEmpty();
    }

    @ParameterizedTest(name = "{index}: value \"{0}\" does not contain any digit")
    @DisplayName("Should not find any digit for given value")
    @ValueSource(strings = {"abc", "XyZwwwSD", "    "})
    @NullSource
    @EmptySource
    void shouldNotFindAnyDigitForGivenValueWhenThereAreNone(String value) {
        // given

        // when
        OptionalInt possibleFirstDigit = numbers.findFirstDigit(value);

        // then
        Assertions.assertThat(possibleFirstDigit)
                .isNotNull()
                .isEmpty();
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNullValue() {
        // given
        String value = null;

        // when + then
        // Klasycze podejście:
//        try {
//            OptionalInt possibleFirstDigit = numbers.findFirstDigit(value);
//            // jeżeli przechodzimy do kolejnej linii kodu - błąd.
//            org.junit.jupiter.api.Assertions.fail();
//        } catch (IllegalArgumentException e) {
//            // Jeżeli tutaj trafiamy - sukces
//        }

        // Wykorzystanie możliwości assertJ
//        Assertions.assertThatIllegalArgumentException()
//                .isThrownBy(() -> numbers.findFirstDigit(value))
//                .withMessage("Value is null")
//                .withNoCause();
    }

    static Stream<Arguments> provideArgsForFindFirstDigitTest() {
        return Stream.of(
                Arguments.of("123abc45def", 1),
                Arguments.of("def354fgh", 3),
                Arguments.of("xyz9", 9),
                Arguments.of("987654321", 9)
        );
    }
}