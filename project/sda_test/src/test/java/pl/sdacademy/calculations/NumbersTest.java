package pl.sdacademy.calculations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

class NumbersTest {

    @ParameterizedTest
    @MethodSource("provideNumbersWithInfoAboutParity")
    void shouldReturnExpectedValue(int value, boolean expected) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, value % 2 == 1);
    }

    @Test
    void shouldFindFirstDigitInString() {
        // given
        Numbers numbers = new Numbers();
        String value = "def5f3d42";

        // when
        OptionalInt possibleFirstDigit = numbers.findFirstDigit(value);

        // then
        Assertions.assertThat(possibleFirstDigit)
                .isNotNull()
                .isPresent()
                .hasValue(5);
    }

    @Test
    void shouldNotFindAnyDigitWhenThereAreNone() {
        // given
        Numbers numbers = new Numbers();
        String value = "abc";

        // when
        OptionalInt possibleFirstDigit = numbers.findFirstDigit(value);

        // then
        Assertions.assertThat(possibleFirstDigit)
                .isEmpty();
    }

    @Test
    void shouldTrimValue() {
        // given
        String value = "  ab X67  kk    ";

        // when
        String actualTrimmedValue = value.trim();

        // then
        Assertions.assertThat(actualTrimmedValue)
                .isEqualTo("ab X67  kk");
    }

    @ParameterizedTest(name = "\"{0}\" does not contain any digit")
    @ValueSource(strings = {"abc", "", "  "})
    @DisplayName("Should not find any digit in given string value when there are none")
    void shouldNotFindAnyDigitForGivenStringValue(String value) {
        // given
        Numbers numbers = new Numbers();

        // when
        OptionalInt possibleFirstDigit = numbers.findFirstDigit(value);

        // then
        Assertions.assertThat(possibleFirstDigit)
                .isEmpty();
    }

    static Stream<Arguments> provideNumbersWithInfoAboutParity() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(6, false)
        );
    }
}