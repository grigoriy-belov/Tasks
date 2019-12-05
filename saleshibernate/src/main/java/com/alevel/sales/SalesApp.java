package com.alevel.sales;

import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class SalesApp {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(SalesApp.class);

        int year = 0;
        try {
            year = Integer.parseInt(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Missing or wrong year argument");
        }

        Configuration configuration = new Configuration().configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Transaction transaction = null;
            try (Session session = sessionFactory.openSession()) {
                transaction = session.beginTransaction();

                Query<Department> listDepartments = session.createQuery("from Department", Department.class);
                List<Department> departments = listDepartments.list();

                String hql = "from DailyReport as d where d.date between :startDateParam and :endDateParam";
                Query<DailyReport> listDailyReports = session.createQuery(hql, DailyReport.class);
                listDailyReports.setParameter("startDateParam", LocalDate.of(year, 1, 1));
                listDailyReports.setParameter("endDateParam", LocalDate.of(year, 12, 31));
                List<DailyReport> dailyReports = listDailyReports.list();

                CSVExportReportHelper.export(departments, dailyReports, year);


                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                logger.error("Error during transaction", e);
            }
        }
    }
}
