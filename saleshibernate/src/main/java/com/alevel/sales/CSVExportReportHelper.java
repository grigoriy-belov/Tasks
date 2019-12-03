package com.alevel.sales;

import java.io.File;

public class CSVExportReportHelper {

    private final String path = "C:\\annual_report.csv";

    private File annualReport;

    public CSVExportReportHelper() {
        annualReport = new File(path);
    }


}
