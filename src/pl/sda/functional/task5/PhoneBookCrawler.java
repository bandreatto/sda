package pl.sda.functional.task5;

import pl.sda.functional.task4.PhoneBook;

import java.util.Optional;

public class PhoneBookCrawler {

    private PhoneBook phoneBook;

    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name) {
        return phoneBook.findPhoneNumberByName(name).orElseThrow(
                () -> new IllegalArgumentException("No phone number found"));
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name) {
        return phoneBook.findPhoneNumberByName(name).orElseGet(() -> phoneBook.toString());
    }

    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber) {
        return phoneBook.findPhoneNumberByName(name)
                .orElseGet(() -> {
                    Optional<String> possibleName = phoneBook.findNameByPhoneNumber(phoneNumber);
                    return possibleName.orElse(null);
                });
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }
}
