package pl.sdacademy.storage;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
class Storage {

    private List<Object> data = new ArrayList<>();

    private final Connection connection;

    // Realizowane w oparciu o adnotację @RequiredArgsConstructor
//    public Storage(Connection connection) {
//        this.connection = connection;
//    }

    int addValue(Object value) {
        // Dodawanie elementów do "magazynu"
        // Zwracamy liczbę aktualnie znajdujących się w "magazynie" elementów
        if (connection.isClosed()) {
            // Sygnalizujemy błąd
            throw new StorageConnectionException(
                    "Connection is closed so data cannot be added");
        }

        data.add(value);
        return data.size();
    }

    boolean removeValue(Object value) {
        // Usuwanie elementu z "magazynu"
        if (connection.isClosed()) {
            throw new StorageConnectionException(
                    "Connection is closed so data cannot be removed");
        }

        return data.remove(value);
    }

    List<Object> getData() {
        // Zwracanie wszystkich elementów w "magazynie"
        if (connection.isClosed()) {
            throw new StorageConnectionException(
                    "Connection is closed so data cannot be retrieved");
        }

        return data;
    }
}
