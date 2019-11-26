package lesson23;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class AppProperties {

    private static String propertiesFile;

    public AppProperties(String path) {
        propertiesFile = path;
    }

    @PropertyKey("connections.limit")
    public String maxConnections;

    @PropertyKey("server.port")
    public String serverPort;

    @PropertyKey("url")
    public String url;

    public String login;


    public static AppProperties initialize(String path) {
        AppProperties appProperties = null;
        try {
            appProperties = new AppProperties(path);
            Properties properties = PropertiesLoader.loadProperties(propertiesFile);
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
