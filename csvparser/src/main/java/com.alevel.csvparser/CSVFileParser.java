package com.alevel.csvparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVFileParser implements CSVParser<Path> {
    @Override
    public CSVTable parse(Path source) throws CSVParsedException {
        try (BufferedReader reader = Files.newBufferedReader(source)) {
            String header = reader.readLine();
            CSVTable table;

        } catch (IOException e) {
            throw new CSVParsedException(e);
        }
    }
}
