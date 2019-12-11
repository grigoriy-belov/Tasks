package com.alevel.sales.dao;

import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class SalesDAOImpl implements SalesDAO {

    @Override
    public List<DailyReport> getDailyReportsForYear(int year) {
        Transaction transaction = null;
        List<DailyReport> dailyReports = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<DailyReport> criteriaQuery = builder.createQuery(DailyReport.class);
            Root<DailyReport> root = criteriaQuery.from(DailyReport.class);
            root.join("department");

            criteriaQuery.where(builder.between(root.get("date"), LocalDate.of(year, 1, 1),
                    LocalDate.of(year, 12, 31)));

            Query<DailyReport> query = session.createQuery(criteriaQuery);
            dailyReports = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return dailyReports;
    }
}
