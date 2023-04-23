package pl.sdacademy.calculations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LinesTest {

    @Test
    void shouldValidateLines() {
        // given
        String value1 = "r.*";
        String value2 = "raz";

        // expectedLines = (value1)
        // actualLines = (value2)
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add(value1);

        List<String> actualLines = List.of(value2);
//        List<String> actualLines = new ArrayList<>();
//        actualLines.add(value2);

        // when + then
//        Assertions.assertIterableEquals(expectedLines, actualLines); // błąd
        Assertions.assertLinesMatch(expectedLines, actualLines);
//        Assertions.assertLinesMatch(actualLines, expectedLines); // błąd
    }
}
