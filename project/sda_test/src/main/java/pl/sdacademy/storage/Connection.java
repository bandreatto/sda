package pl.sdacademy.storage;

class Connection {

    private boolean state;

    void open() throws InterruptedException {
        Thread.sleep(500); // slow opening connection (0.5s delay)
        state = true;
    }

    void close() throws InterruptedException {
        Thread.sleep(500); // slow closing connection (0.5s delay)
        state = false;
    }

    boolean isOpened() {
        return state;
    }

    boolean isClosed() {
        return !isOpened();
    }

    void refresh() {
        System.out.println("Refreshing the connection!");
    }
}
