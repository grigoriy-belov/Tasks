package lesson23;

import java.util.Properties;

public interface PropertiesMapper {

    <T> T map (Properties properties, Class<T> type) throws PropertiesMappingException;

}
