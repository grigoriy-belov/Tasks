package com.alevel.socialnetwork;

import com.alevel.socialnetwork.entity.Comment;
import com.alevel.socialnetwork.entity.Photo;
import com.alevel.socialnetwork.entity.User;
import com.alevel.socialnetwork.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CountLikesAndDisplayUsers {
    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);

    public static void main(String[] args) {
        long entityId = 2L;
        Class entityClass = User.class;

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (session; sessionFactory) {
            Transaction transaction = session.beginTransaction();

            if (entityClass.equals(User.class)) {
                User user = session.get(User.class, entityId);

            }


            transaction.commit();
        } catch (Exception e) {
            log.error("Error while populating db with example data", e);
            session.getTransaction().rollback();
        }
    }
}
