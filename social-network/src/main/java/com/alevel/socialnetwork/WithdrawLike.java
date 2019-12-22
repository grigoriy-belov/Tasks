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
        long userId = 1l;
        long targetId = 2l;
        Class entity = PhotoLike.class;

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class, userId);

            if (entity == UserLike.class) {
                for (UserLike like : user.getUserLikes()) {
                    if (like.getId() == targetId) {
                        user.removeUserLike(like);
                    }
                }
            } else if (entity == PhotoLike.class) {
                for (PhotoLike like : user.getPhotoLikes()) {
                    if (like.getId() == targetId) {
                        user.removePhotoLike(like);
                    }
                }
            } else if (entity == Comment.class) {
                for (CommentLike like : user.getCommentLikes()) {
                    if (like.getId() == targetId) {
                        user.removeCommentLike(like);
                    }
                }
            }

            session.save(user);

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while populating db with example data", e);
            session.getTransaction().rollback();
        }
    }
}
