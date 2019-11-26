package com.alevel.csvparser;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class CSVRow {

    private final List<CSVCell> cells = new ArrayList<>();

    public void append(CSVCell value) {
        cells.add(value);
    }

    public int size() {
        return cells.size();
    }

    public boolean isEmpty() {
        return cells.isEmpty();
    }

    public List<String> asList() {
        return new ArrayList<>(cells);
    }
}
