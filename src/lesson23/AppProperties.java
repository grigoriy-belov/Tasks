package lesson23;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class AppProperties {

    private static final String PROPERTIES_FILE = "app.properties";

    @PropertyKey("connections.limit")
    public String maxConnections;

    @PropertyKey("server.port")
    public String serverPort;

    @PropertyKey("url")
    public String url;

    public String login;


    public static AppProperties initialize() {
        AppProperties appProperties = null;
        try {
            Properties properties = PropertiesLoader.loadProperties(PROPERTIES_FILE);
            appProperties = new AppProperties();
            Class<?> clazz = appProperties.getClass();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(PropertyKey.class)) {
                    String value = properties.getProperty(field.getAnnotation(PropertyKey.class).value());
                    field.set(appProperties, value);
                }
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return appProperties;
    }
}
