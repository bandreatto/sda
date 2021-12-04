package pl.sda.local.examples;

import lombok.AllArgsConstructor;

import java.util.List;

public class LocalService {

    public static void main(String[] args) {
        List<String> names = List.of("Kasia", "Magda", "Gosia");
        List<String> surnames = List.of("Piszczyk", "Olszańska", "Budrzynska");
        int someConstant = 3;

        @AllArgsConstructor
        class Name {

            private static final String DEFAULT_NAME = "unknown";

            private final String firstName;

            private final String lastName;

            public String getReadableName() {
                System.out.println("I can use outer constant: " + someConstant);
                return firstName + " " + lastName;
            }
        }

//        someConstant++;

        for (int i = 0; i < 3; i++) {
            Name name = new Name(names.get(i), surnames.get(i));
            System.out.println(name.getReadableName());
        }
    }
}
