package com.alevel.socialnetwork;

import com.alevel.socialnetwork.entity.*;
import com.alevel.socialnetwork.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithdrawLike {
    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);

    public static void main(String[] args) {
        long userId = 3l;
        long targetId = 2l;

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class, userId);
            User targetUser = session.get(User.class, targetId);
            UserLike userLike = session.load(UserLike.class, new UserLikeId(user, targetUser));
            session.remove(userLike);

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while removing like from db", e);
            session.getTransaction().rollback();
        }
    }
}
