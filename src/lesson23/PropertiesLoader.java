package lesson23;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public Properties load(String path) throws PropertiesLoadException {
        Properties properties;
        try (InputStream props = new FileInputStream(path)) {
            properties = new Properties();
            properties.load(props);
        } catch (IOException e) {
            throw new PropertiesLoadException(e);
        }
        return properties;
    }
}
