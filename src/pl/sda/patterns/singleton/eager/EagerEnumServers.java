package pl.sda.patterns.singleton.eager;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum EagerEnumServers {

    INSTANCE;

    private List<String> list = new ArrayList<>();

    public boolean addServer(String server) {
        if (server != null
                && server.startsWith("http")
                && !list.contains(server)) {
            return list.add(server);
        }

        return false;
    }

    public List<String> getHttpServers() {
        return getServers("http:");
    }

    public List<String> getHttpsServers() {
        return getServers("https:");
    }

    private List<String> getServers(String prefix) {
        return getServers(s -> s.startsWith(prefix));
    }

    private List<String> getServers(Predicate<String> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
