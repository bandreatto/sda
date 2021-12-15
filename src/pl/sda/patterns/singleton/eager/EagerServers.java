package pl.sda.patterns.singleton.eager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EagerServers {

    private static final EagerServers INSTANCE = new EagerServers();

    private List<String> list = new ArrayList<>();

    private EagerServers() {

    }

    public static EagerServers getInstance() {
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
