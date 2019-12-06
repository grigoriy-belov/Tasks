package com.alevel.sales;

import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.entity.Department;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CSVReportExportService {

    private static final Path path = Paths.get("misc\\files\\annual_report.csv");

    public static void export(List<Department> departments, int year) {
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.CREATE)) {

            bufferedWriter.write("Department,Profit");
            bufferedWriter.newLine();
            for (Department department : departments) {
                long profit = 0;
                for (DailyReport dailyReport : department.getDailyReports()) {
                    if (dailyReport.getDate().getYear() == year) {
                        profit += dailyReport.getProfit();
                    }
                }
                bufferedWriter.write(department.getName() + "," + profit / 100);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
