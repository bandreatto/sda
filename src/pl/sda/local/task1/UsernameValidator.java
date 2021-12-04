package pl.sda.local.task1;

public class UsernameValidator {

    public String validateName(String name) {

        class Username {

            private static final String UNKNOWN = "unknown";
            private static final String INVALID = "invalid";

            String format() {
                if (name == null || name.isEmpty()) {
                    return UNKNOWN;
                } else if (name.length() < 4) {
                    return INVALID;
                }

                return name;
            }
        }

        Username username = new Username();
        return username.format();
    }

    public static void main(String[] args) {
        UsernameValidator usernameValidator = new UsernameValidator();
        System.out.println(usernameValidator.validateName(null));
        System.out.println(usernameValidator.validateName(""));
        System.out.println(usernameValidator.validateName("xyz"));
        System.out.println(usernameValidator.validateName("Tomasz"));
    }
}
