package com.alevel.sales.dao;

import com.alevel.sales.entity.Department;
import com.alevel.sales.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SalesDAOImpl implements SalesDAO {

    @Override
    public List<Department> getDepartments() {
        Transaction transaction = null;
        List<Department> departments = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "from Department";
            Query<Department> listDepartments = session.createQuery(hql, Department.class);
            departments = listDepartments.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return departments;
    }
}
