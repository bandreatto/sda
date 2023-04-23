package pl.sdacademy.calculations;

import java.util.OptionalInt;

class Numbers {

    // "123abc45def" -> [1]
    // "def5f3d42" -> [5]
    // "xyz9" -> [9]
    // "987654321" -> [9]
    // "abc" -> []
    // "" -> []
    // null -> []

    // OptionalInt - kontener (pudełko), które zawiera lub nie pojedynczy element typu int
    OptionalInt findFirstDigit(String value) {
        if (value == null) {
            // zwracamy puste "pudełko"
            return OptionalInt.empty();
        }

        // tworzymy tablicę znaków
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) { // iterujemy po kolejnych znakach value (string'a)
            char currentChar = chars[i]; // aktualnie przetwarzany znak
            if (Character.isDigit(currentChar)) { // sprawdzamy czy dany znak jest cyfrą
                // zamieniamy 'char' na 'int'
                int foundFirstDigit = Character.getNumericValue(currentChar);
                // tworzymy "pudełko", które zawiera pojedynczny element, tj.: foundFirstDigit
                return OptionalInt.of(foundFirstDigit);
            }
        }

        // nie znaleźliśmy cyfry, więc zwracamy puste "pudełko"
        return OptionalInt.empty();
//        return OptionalInt.of(4);
    }
}
