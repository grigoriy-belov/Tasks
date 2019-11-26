package lesson23;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String resourceFileName) throws IOException {
        Properties properties = new Properties();
        try (InputStream props = new FileInputStream(resourceFileName)) {
            properties.load(props);
        }
        return properties;
    }
}
