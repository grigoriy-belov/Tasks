package lesson23;

public class AppPropertiesDemo {
    public static void main(String[] args) {
        AppProperties appProperties = AppProperties.initialize("src/lesson23/app.properties");
        System.out.println(appProperties.maxConnections);
        System.out.println(appProperties.serverPort);
        System.out.println(appProperties.url);
    }
}
