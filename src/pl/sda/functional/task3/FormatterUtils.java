package pl.sda.functional.task3;

import java.util.function.Function;

public class FormatterUtils {

    public static String format(Function<String, String> formatter, String value) {
        return formatter.apply(value);
    }

    public static void main(String[] args) {
//        String formattedValue = format(p -> p.toUpperCase());
        String formattedValue = format(String::toUpperCase, "tekst1");
        System.out.println(formattedValue);

        formattedValue = format(String::toUpperCase, "RazDwatrzy");
        System.out.println(formattedValue);
    }
}

