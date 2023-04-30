package pl.sdacademy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LinesMatchTest {

    @Test
    void shouldValidateStringLines() {
        // given
        List<String> expectedLines
                = Stream.of("r.*").collect(Collectors.toList()); // jeden element: "r.*"
        // r.* - string zaczyna się od litery "r" a po niej występuje
        // dowolna liczba (interpretacja: *) dowolnych znaków (intepretacja: .)
        //Przykłady:
        // "rower", "raz", "razdwatrzy", "r"
        // Błąd:
        // "R", "test", "", "."
        List<String> actualLines = new ArrayList<>();
        actualLines.add("ryzykownie"); // jeden element: "ryzykownie"
        // alternatywnie:
//        List<String> actualLines = List.of("ryzykownie");

        // when + then
//        Assertions.assertIterableEquals(expectedLines, actualLines); // asercja ta zawodzi
        Assertions.assertLinesMatch(expectedLines, actualLines);
    }
}
