package com.alevel.sales;

import com.alevel.sales.dao.SalesDAO;
import com.alevel.sales.dao.SalesDAOImpl;
import com.alevel.sales.util.CSVReportExportUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SalesApp {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(SalesApp.class);
        int year = 0;

        try {
            year = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            logger.error("Missing or invalid year argument.");
        }

        SalesDAO salesDAO = new SalesDAOImpl();
        CSVReportExportUtil.export(salesDAO.getDepartments(), salesDAO.getDailyReportsByYear(year));
    }
}
