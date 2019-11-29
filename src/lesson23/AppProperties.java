package lesson23;

public class AppProperties {

    @PropertyKey("connections.limit")
    public int maxConnections;

    @PropertyKey("server.port")
    public int serverPort;

    @PropertyKey("url")
    public String url;

    @PropertyKey("login")
    public String login;

}
