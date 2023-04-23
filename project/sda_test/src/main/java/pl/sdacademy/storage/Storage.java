package pl.sdacademy.storage;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class Storage {

    private List<Object > data = new ArrayList<>();

    private final Connection connection;

    int addValue(Object value) {
        if (connection.isClosed()) {
            throw new StorageConnectionException("Connection is closed so data cannot be added!");
        }

        data.add(value);
        return data.size();
    }

    boolean removeValue(Object value) {
        if (connection.isClosed()) {
            throw new StorageConnectionException(
                    "Connection is closed so data cannot be removed!");
        }

        return data.remove(value);
    }

    List<Object> getData() {
        if (connection.isClosed()) {
            throw new StorageConnectionException(
                    "Connection is closed so data cannot be retrieved!");
        }

        return data;
    }
}
