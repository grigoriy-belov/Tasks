package lesson23;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Properties;

public class AnnotationBasedPropertiesMapper<T> implements PropertiesMapper {

    @Override
    public <T> T map(Properties properties, Class<T> type) throws PropertiesMappingException {
        try {
            Constructor<T> constructor = type.getConstructor();
            Field[] declaredFields = type.getDeclaredFields();

           T instance = constructor.newInstance();

            for (Field field : declaredFields) {
                PropertyKey propertyKey = field.getAnnotation(PropertyKey.class);
                if (propertyKey != null && field.trySetAccessible()) {
                    String value = properties.getProperty(propertyKey.value());

                    Class<?> fieldType = field.getType();

                    if (fieldType.equals(String.class)) {
                        field.set(instance, value);
                    } else if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
                        field.setInt(instance, Integer.parseInt(value));
                    } else if (fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)) {
                        field.setBoolean(instance, Boolean.parseBoolean(value));
                    } else if (fieldType.equals(Double.class) || fieldType.equals(double.class)) {
                        field.setDouble(instance, Double.parseDouble(value));
                    } else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
                        field.setLong(instance, Long.parseLong(value));
                    }
                }
            }
            return instance;
        } catch (Exception e) {
            throw new PropertiesMappingException(e);
        }
    }
}
