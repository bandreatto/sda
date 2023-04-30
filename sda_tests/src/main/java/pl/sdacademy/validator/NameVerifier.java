package pl.sdacademy.validator;

class NameVerifier {

    boolean isNameValid(String name) {
        // TRUE wtedy i tylko wtedy, gdy (koniunkcja warunków):
        // 1. name nie jest null
        // 2. name nie jest pustym łańcuchem znaków
        // 3. name nie składa się wyłącznie z dużych liter
        // 4. name nie składa się wyłącznie z małych liter
        // FALSE w przeciwnym wypadku
        return name != null
                && !name.isBlank()
                && !name.equals(name.toUpperCase())
                && !name.equals(name.toLowerCase());
    }
}
