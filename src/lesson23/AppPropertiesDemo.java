package lesson23;

import java.util.Properties;

public class AppPropertiesDemo {
    public static void main(String[] args) throws Exception {
        PropertiesMapper propertiesMapper = new AnnotationBasedPropertiesMapper<>();
        Properties properties = new PropertiesLoader().load("misc/files/app.properties");
        AppProperties appProperties = propertiesMapper.map(properties, AppProperties.class);
        System.out.println(appProperties.maxConnections);
        System.out.println(appProperties.serverPort);
        System.out.println(appProperties.url);
        System.out.println(appProperties.login);
    }
}
