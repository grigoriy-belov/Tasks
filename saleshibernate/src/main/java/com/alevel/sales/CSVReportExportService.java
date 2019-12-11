package com.alevel.sales;

import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.entity.Department;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReportExportService {

    private static final Path path = Paths.get("misc\\files\\annual_report.csv");

    public static void export(List<DailyReport> dailyReports) {
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {

            bufferedWriter.write("Department,Profit");
            bufferedWriter.newLine();

            for (Map.Entry<Department, Long> entry : getDepartmentsProfit(dailyReports).entrySet()) {
                bufferedWriter.write(entry.getKey().getName() + "," + entry.getValue() / 100);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<Department, Long> getDepartmentsProfit(List<DailyReport> dailyReports) {
        Map<Department, Long> departments = new HashMap<>();

        for (DailyReport dailyReport : dailyReports) {

            Department department = dailyReport.getDepartment();
            Long profit = dailyReport.getProfit();

            if (!departments.containsKey(department)) {
                departments.put(department, profit);
            } else {
                departments.put(department, departments.get(department) + profit);
            }
        }
        return departments;
    }
}
