package lesson23;

public class AppProperties {

    @PropertyKey(key = "connections.limit")
    public int maxConnections;

    @PropertyKey(key = "server.port")
    public String serverPort;

    @PropertyKey(key = "url")
    public String url;

    public static void main(String[] args) {

    }

    private static void init() {

    }
}
