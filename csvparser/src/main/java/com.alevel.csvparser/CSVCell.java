package com.alevel.csvparser;

public class CSVCell {
    private String value;

    public String get() {
        return value;
    }

    public int getInt() {
        return Integer.parseInt(value);
    }

    public long getLong() {
        return Long.parseLong(value);
    }

    public double getDouble() {
        return Double.parseDouble(value);
    }

    public boolean getBoolean() {
        return Boolean.parseBoolean(value);
    }


}
