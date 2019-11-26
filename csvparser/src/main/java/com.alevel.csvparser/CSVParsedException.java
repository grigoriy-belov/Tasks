package com.alevel.csvparser;

public class CSVParsedException extends Exception {
    public CSVParsedException(String message) {
        super(message);
    }

    public CSVParsedException(Throwable cause) {
        super(cause);
    }
}
