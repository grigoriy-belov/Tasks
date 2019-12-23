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
        long userId = 2L;
        long targetId = 1L;
        String entity = "Photo";

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class, userId);
            if (entity.equals("User")) {
                User targetUser = session.get(User.class, targetId);
                UserLike userLike = session.get(UserLike.class, new UserLike(user, targetUser));
                session.remove(userLike);
            } else if (entity.equals("Photo")) {
                Photo targetPhoto = session.get(Photo.class, targetId);
                PhotoLike userLike = session.get(PhotoLike.class, new PhotoLike(user, targetPhoto));
                session.remove(userLike);
            } else if (entity.equals("Comment")) {
                Comment targetComment = session.get(Comment.class, targetId);
                CommentLike userLike = session.get(CommentLike.class, new CommentLike(user, targetComment));
                session.remove(userLike);
            }

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while removing like from db", e);
            session.getTransaction().rollback();
        }
    }
}
