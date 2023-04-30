package pl.sdacademy.storage;

class Connection {

    // true - połączenie otwarte
    // false - połączenie zamknięte
    private boolean state;

    void open() throws InterruptedException {
        Thread.sleep(500); // "zasypiamy" na 0.5s
        state = true;
    }

    void close() throws InterruptedException {
        Thread.sleep(500); // "zasypiamy" na 0.5s
        state = false;
    }

    boolean isOpened() {
        // true jeśli połączenie jest otwarte
        return state;
    }

    boolean isClosed() {
        // true jeśli połączenie jest zamknięte
        return !isOpened();
    }

    void refresh() {
        // odnowienie połączenia
        System.out.println("Refreshing connection...");
    }
}
