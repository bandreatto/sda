package pl.sda.functional.task5;

import pl.sda.functional.task4.PhoneBook;

public class PhoneBookCrawlerTest {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(phoneBook);

        System.out.println(phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Jos de Vos"));
//        System.out.println(phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Ted"));

        System.out.println("------------");
        System.out.println(phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Kris de Vis"));
        System.out.println(phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Ted"));

        System.out.println("------------");
        System.out.println(phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Jos de Vos", ""));
        System.out.println(phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("", "016/161617"));
    }
}
