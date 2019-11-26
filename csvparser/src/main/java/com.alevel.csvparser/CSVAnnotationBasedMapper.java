package com.alevel.csvparser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVAnnotationBasedMapper implements CSVMapper {

    @Override
    public <T> List<T> map(CSVTable table, Class<T> type) throws CSVMappingException {
        List<CSVRow> rows = table.getRows();

        List<T> result = new ArrayList<>(rows.size());

        Constructor<T> constructor = type.getConstructor();

        Field[] declaredFields = type.getDeclaredFields();

        Map<String, Field>  columnToFieldMap = new HashMap<>(declaredFields.length);

        for (Field declaredField : declaredFields) {
            CSVColumn column = declaredField.getAnnotation(CSVColumn.class);
            if (column != null && declaredField.trySetAccessible()) {
                columnToFieldMap.put(column.value(), declaredField);
            }

        }

        for (CSVRow row : rows) {

            T instance = constructor.newInstance();


        }
    }
}
