package pl.sda.patterns.singleton.lazy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Servers {

    private static Servers INSTANCE;

    private List<String> list = new ArrayList<>();

    private Servers() {

    }

    public static Servers getInstance() {
        if (INSTANCE == null) {
            synchronized (Servers.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Servers();
                }
            }
        }

        return INSTANCE;
    }

    public boolean addServer(String server) {
        if (server != null
//                && (server.startsWith("http") || server.startsWith("https"))
                && server.startsWith("http")
                && !list.contains(server)) {
            return list.add(server);
        }

        return false;
    }

    public List<String> getHttpServers() {
//        return list.stream()
//                .filter(s -> s.startsWith("http:"))
//                .collect(Collectors.toList());

//        return getServers(s -> s.startsWith("http:"));
        return getServers("http:");
    }

    public List<String> getHttpsServers() {
//        return list.stream()
//                .filter(s -> s.startsWith("https:"))
//                .collect(Collectors.toList());
//        return getServers(s -> s.startsWith("https:"));
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
