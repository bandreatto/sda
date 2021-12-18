package pl.sda.patterns.strategy;

public interface SpacesModificationStrategy {

//    String modify(String input);

    default void processIfSpace(StringBuilder stringBuilder) {
        // noop
    }

    default void processIfNotSpace(StringBuilder stringBuilder, char c) {
        stringBuilder.append(c);
    }

    default String modify(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c :input.toCharArray()){
            if (c == ' ') {
                // wykonaj czynnosc gdy spacja...
                processIfSpace(stringBuilder);
            } else {
                // wykonaj czynnosc gdy brak spacji...
                processIfNotSpace(stringBuilder, c);
            }
        }

        return stringBuilder.toString();
    };
}
