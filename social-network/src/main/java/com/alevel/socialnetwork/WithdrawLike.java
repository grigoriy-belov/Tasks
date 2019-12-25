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
        String likeType = args[0];
        long userId = Long.parseLong(args[1]);
        long targetId = Long.parseLong(args[2]);

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            Transaction transaction = session.beginTransaction();
            LikeEntity like = null;

            User user = session.get(User.class, userId);

            if (likeType.equals("User")) {
                like = session.get(UserLike.class, targetId);
            } else if (likeType.equals("Comment")) {
                like = session.get(CommentLike.class, targetId);
            } else if (likeType.equals("Photo")) {
                like = session.get(PhotoLike.class, targetId);
            }

            user.removeLike(like);
            session.save(user);

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while populating db with example data", e);
            session.getTransaction().rollback();
        }
    }
}
