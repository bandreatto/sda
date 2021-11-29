package pl.sda.enumerations.examples;

public enum JsonSerializationStrategy implements IdProvider {
    SNAKE_CASE(5),
    CAMEL_CASE(2) {
        @Override
        public String getDescription() {
            return "extra description";
        }
    },
    KEBAB_CASE(-100); // public static final String

    private final int id;

    JsonSerializationStrategy(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return "default description";
    }

    public static JsonSerializationStrategy of(int actualId) {
        JsonSerializationStrategy[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i].getId() == actualId) {
                return values[i];
            }
        }

        return null;
    }
}
