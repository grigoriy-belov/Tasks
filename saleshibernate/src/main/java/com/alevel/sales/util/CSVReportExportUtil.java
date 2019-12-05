package com.alevel.sales.util;

import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.entity.Department;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVReportExportUtil {

    private static final Path path = Paths.get("D:\\annual_report.csv");

    public static void export(List<Department> departments, List<DailyReport> dailyReports) {

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            bufferedWriter.write("Department, Profit");
            bufferedWriter.newLine();
            for (Department department : departments) {
                long profit = 0;
                for (DailyReport dailyReport : dailyReports) {
                    if (department.equals(dailyReport.getDepartment())) {
                        profit += dailyReport.getProfit();
                    }
                }
                profit /= 100;
                bufferedWriter.write(department.getName() + "," + profit);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
