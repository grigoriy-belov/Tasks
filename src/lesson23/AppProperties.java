package lesson23;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class AppProperties {

    private static final String PROPERTIES_FILE = "app.properties";

    public AppProperties() {
    }

    public static void main(String[] args) {
        AppProperties appProperties = AppProperties.initialize();
        System.out.println(appProperties.maxConnections);
        System.out.println(appProperties.serverPort);
        System.out.println(appProperties.url);
    }

    @PropertyKey("connections.limit")
    public String maxConnections;

    @PropertyKey("server.port")
    public String serverPort;

    @PropertyKey("url")
    public String url;


    public static AppProperties initialize() {
        AppProperties appProperties = null;
        try {
            Properties properties = PropertiesLoader.loadProperties(PROPERTIES_FILE);
            appProperties = new AppProperties();
            Class<?> clazz = appProperties.getClass();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(PropertyKey.class)) {
                    field.set(appProperties, field.getAnnotation(PropertyKey.class).value());
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return appProperties;
    }
}
