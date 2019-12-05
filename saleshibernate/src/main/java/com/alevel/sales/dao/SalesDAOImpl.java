package com.alevel.sales.dao;

import com.alevel.sales.util.HibernateSessionFactoryUtil;
import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.entity.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class SalesDAOImpl implements SalesDAO {
    @Override
    public List<Department> getDepartments() {
        Transaction transaction = null;
        List<Department> departments = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Query<Department> listDepartments = session.createQuery("from Department", Department.class);
            departments = listDepartments.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return departments;
    }

    @Override
    public List<DailyReport> getDailyReportsByYear(int year) {
        Transaction transaction = null;
        List<DailyReport> dailyReports = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "from DailyReport as d where d.date between :startDateParam and :endDateParam";
            Query<DailyReport> listDailyReports = session.createQuery(hql, DailyReport.class);
            listDailyReports.setParameter("startDateParam", LocalDate.of(year, 1, 1));
            listDailyReports.setParameter("endDateParam", LocalDate.of(year, 12, 31));
            dailyReports = listDailyReports.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return dailyReports;
    }
}
