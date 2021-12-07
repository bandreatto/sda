package pl.sda.functional.task4;

import java.util.Optional;

public class PhoneBookTest {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Optional<String> toekanNumber =
                phoneBook.findPhoneNumberByName("An de Toekan");
        toekanNumber.ifPresentOrElse(System.out::println,
                () -> System.out.println("Not found toekan number!"));

        System.out.println("---------------------");
        Optional<String> possibleName = phoneBook.findNameByPhoneNumber("016/161618");
        if (possibleName.isPresent()) {
            String name = possibleName.get();
            System.out.println(name);
        }
    }
}
