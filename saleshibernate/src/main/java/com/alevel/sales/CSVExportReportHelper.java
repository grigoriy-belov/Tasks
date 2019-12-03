package com.alevel.sales;

import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.entity.Department;

import java.io.File;
import java.util.List;

public class CSVExportReportHelper {

    private final String path = "C:\\annual_report.csv";

    private File annualReport;

    public CSVExportReportHelper() {
        annualReport = new File(path);
    }

    public void export(List<Department> departments) {
        try ()
        for (Department department : departments) {
            long profit = 0;
            for (DailyReport dailyReport : department.getDailyReports()) {
                profit += dailyReport.getProfit();
            }
            System.out.println(department.getName() + ": " + profit);
        }
    }
}
