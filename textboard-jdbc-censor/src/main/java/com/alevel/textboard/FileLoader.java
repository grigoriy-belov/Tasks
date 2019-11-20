package com.alevel.textboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileLoader {

    private String filePath;
    private Path path;


    public FileLoader(String filePath) {
        this.filePath = filePath;
        path = Paths.get(filePath);
    }

    public List<String> getBlackList() {
        List<String> lines = null;
        List<String> blackList = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            blackList.addAll(Arrays.asList(line.split(", ")));
        }
        return blackList;
    }
}
