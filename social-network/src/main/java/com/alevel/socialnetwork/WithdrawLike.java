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
        long userId = Long.parseLong(args[0]);
        long targetId = Long.parseLong(args[1]);
        String entity = args[2];

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            Transaction transaction = session.beginTransaction();

            User user = session.get(User.class, userId);
            switch (entity) {
                case "User": {
                    User targetUser = session.get(User.class, targetId);
                    UserLike userLike = session.get(UserLike.class, new UserLike(user, targetUser));
                    session.remove(userLike);
                    break;
                }
                case "Photo": {
                    Photo targetPhoto = session.get(Photo.class, targetId);
                    PhotoLike userLike = session.get(PhotoLike.class, new PhotoLike(user, targetPhoto));
                    session.remove(userLike);
                    break;
                }
                case "Comment": {
                    Comment targetComment = session.get(Comment.class, targetId);
                    CommentLike userLike = session.get(CommentLike.class, new CommentLike(user, targetComment));
                    session.remove(userLike);
                    break;
                }
            }

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while removing like from db", e);
            session.getTransaction().rollback();
        }
    }
}
