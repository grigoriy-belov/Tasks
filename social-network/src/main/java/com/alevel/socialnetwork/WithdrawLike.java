package com.alevel.socialnetwork;

import com.alevel.socialnetwork.entity.*;
import com.alevel.socialnetwork.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WithdrawLike {
    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);

    public static void main(String[] args) {
        long userId = 2l;
        long targetId = 2l;
        Class entity = PhotoLike.class;

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class, userId);
            UserLike userLike = new UserLike(user, session.get(User.class, 1L));
            session.save(userLike);
            session.save(user);

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while populating db with example data", e);
            session.getTransaction().rollback();
        }
    }
}
