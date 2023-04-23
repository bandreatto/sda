package pl.sdacademy.storage;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    private static final String EXAMPLE_VALUE = "HelloSdaZdJavaPol";

    private static Connection connection;
    private Storage storage;

    @BeforeAll
    static void beforeAll() throws InterruptedException {
        connection = new Connection();
        connection.open();
    }

    @AfterAll
    static void afterAll() throws InterruptedException {
        connection.close();
    }

    @BeforeEach
    void beforeEach() {
        storage = new Storage(connection);
    }

    @AfterEach
    void afterEach() {
        connection.refresh();
    }

    @DisplayName("Should add example value to storage when connection is opened.")
    @Test
    void shouldAddToStorage() throws InterruptedException {
        // given
//        Connection connection = new Connection();
//        connection.open();
//        Storage storage = new Storage(connection);

        // when
        int actualSize = storage.addValue(EXAMPLE_VALUE);

        // then
        assertEquals(1, actualSize);
        assertTrue(storage.getData().contains(EXAMPLE_VALUE));
        assertEquals(1, storage.getData().size());
    }

    @Test
    @Disabled
    void shouldRemoveExistingData() {
        // given
        storage.addValue(EXAMPLE_VALUE);

        // when
        boolean removedSuccessfully = storage.removeValue(EXAMPLE_VALUE);

        // then
        assertTrue(removedSuccessfully);
        assertFalse(storage.getData().contains(EXAMPLE_VALUE));
        assertEquals(0, storage.getData().size());
    }

    @Test
    void shouldNotRemoveNonExistingData() {
        // given
        storage.addValue(EXAMPLE_VALUE);

        // when
        boolean removedSuccessfully = storage.removeValue("NonExistingData");

        // then
        assertFalse(removedSuccessfully);
        assertEquals(1, storage.getData().size());
    }
}