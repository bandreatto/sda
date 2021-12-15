package pl.sda.patterns.singleton.lazy;

import java.util.List;

public class ServersService {

    public static void main(String[] args) {
        Servers servers = Servers.getInstance();
        servers.addServer("http://1111");
        servers.addServer("https://22222");
        servers.addServer("33333");
        servers.addServer("http://44444");
        servers.addServer("https://55555");
        servers.addServer("https://66666");

        List<String> httpsServers = servers.getHttpsServers();
        System.out.println(httpsServers);
        System.out.println("-------------");
        List<String> httpServers = servers.getHttpServers();
        System.out.println(httpServers);
    }
}
