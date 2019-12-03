package com.alevel.sales;

import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.entity.Department;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVExportReportHelper {

    private static final String path = "C:\\annual_report.csv";

    public static void export(List<Department> departments) {

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path))) {
            for (Department department : departments) {
                long profit = 0;
                for (DailyReport dailyReport : department.getDailyReports()) {
                    profit += dailyReport.getProfit();
                }
                bufferedWriter.write(department.getName() + "," + profit);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
