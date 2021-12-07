package pl.sda.functional.task4;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class PhoneBook {

    private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<>();

    static {
        PHONE_NUMBERS.put("Jos de Vos", "016/161616");
        PHONE_NUMBERS.put("An de Toekan", "016/161617");
        PHONE_NUMBERS.put("Kris de Vis", "016/161618");
    }

    @Getter
    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

    public Optional<String> findPhoneNumberByName(String name) {
        return Optional.ofNullable(phoneBookEntries.get(name));
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber) {
        Set<Map.Entry<String, String>> set = phoneBookEntries.entrySet();
        for (Map.Entry<String, String> entry : set) {
            String phoneNumberInBook = entry.getValue();
            if (phoneNumberInBook != null && phoneNumberInBook.equals(phoneNumber)) {
                String name = entry.getKey();
                return Optional.ofNullable(name);
            }
        }

        return Optional.empty();
    }
}
