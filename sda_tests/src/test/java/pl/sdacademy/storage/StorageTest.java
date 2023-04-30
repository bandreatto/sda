package pl.sdacademy.storage;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {

    private static Connection connection;

    private Storage storage;

    @BeforeAll
    static void beforeAll() throws InterruptedException {
        connection = new Connection();
        // Wywołanie metody open jest "złożone czasowo"
        connection.open();
    }

    @AfterAll
    static void afterAll() throws InterruptedException {
        connection.close();
    }

    @BeforeEach
    void beforeEach() {
        this.storage = new Storage(connection);
    }

    @AfterEach
    void afterEach() {
        connection.refresh();
    }

    @Test
    void shouldAddDataToStorage() {
        // given
        String data = "Hello from SDA";

        // when
        int actualSize = storage.addValue(data);

        // then
        assertEquals(1, actualSize);
        assertTrue(storage.getData().contains(data));
        assertEquals(1, storage.getData().size());
    }

    @Test
    void shouldRemoveExistingData() {
        // given
        String data = "Hello from SDA";
        storage.addValue(data);

        // when
        boolean actuallyRemoved = storage.removeValue(data);

        // then
//        assertEquals(true, actuallyRemoved);
        assertTrue(actuallyRemoved);
    }

    @Test
    void shouldNotRemoveNonExistingData() {
        // given
        String data = "Hello from SDA";
        storage.addValue(data);

        // when
        boolean actuallyRemoved = storage.removeValue("Hello from another course!");

        // then
        assertFalse(actuallyRemoved);
    }
}