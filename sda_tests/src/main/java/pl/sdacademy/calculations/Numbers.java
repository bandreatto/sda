package pl.sdacademy.calculations;

import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Numbers {

    // "123abc45def" -> [1]
    // "def354fgh" -> [3]
    // "xyz9" -> [9]
    // "987654321" -> [9]
    // "abc" -> []
    // "    " -> []
    // "" -> []
    // null -> []
    OptionalInt findFirstDigit(String value) {
        // --- Podpowiedzi:::
        // 1. Character.isDigit
//        https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isDigit-char-
        // 2. Character.getNumericValue
//        https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#getNumericValue-char-
        // 3. "Puste pudeko": OptionalInt.empty()
        // 4. Pudełko z elementem typu int: OptionalInt.of(intValue);

        // --- Pierwsze rozwiązanie
//        if (value == null) {
//            return OptionalInt.empty();
//        }
//
//        char[] chars = value.toCharArray();
//        for (char currentChar : chars) {
//            if (Character.isDigit(currentChar)) {
//                int firstDigit = Character.getNumericValue(currentChar);
//                // Zwracały pudełko z pierwszą z napotkanych cyfr
//                return OptionalInt.of(firstDigit);
//            }
//        }
//
//        // Zwracamy "puste pudełko"
//        return OptionalInt.empty();

        // -- Drugie rozwiązanie (w oparciu o strumienie)
//            if (value == null) {
//                return OptionalInt.empty();
//            }
//
//            IntStream charsStream = value.chars();
//            return charsStream
//                    .filter(currentChar -> Character.isDigit(currentChar)) // sprawdzamy czy cyfra
//                    .map(currentChar -> Character.getNumericValue(currentChar)) // zmieniamy char'a na int'a
//                    .findFirst(); // zwracamy OptionalInt

        // -- Trzecie rozwiązanie (w oparciu o wyrażenia regularne)
        if (value == null) {
//            throw new IllegalArgumentException("Value is null");
            return OptionalInt.empty();
        }

        Pattern pattern = Pattern.compile("(\\d)"); // szukamy pierwszego wystąpienia cyfry
        Matcher matcher = pattern.matcher(value);
        return matcher.find()
                ? OptionalInt.of(Integer.parseInt(matcher.group()))
                : OptionalInt.empty();
    }
}
