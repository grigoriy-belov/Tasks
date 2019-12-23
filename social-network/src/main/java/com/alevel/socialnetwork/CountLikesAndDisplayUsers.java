package com.alevel.socialnetwork;

import com.alevel.socialnetwork.entity.*;
import com.alevel.socialnetwork.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.PropertyHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CountLikesAndDisplayUsers {
    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);

    public static void main(String[] args) {
        long entityId = 2L;
        String entity = "Photo";

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (session; sessionFactory) {
            Transaction transaction = session.beginTransaction();

            if (entity.equals("User")) {
                User user = session.get(User.class, entityId);
                List<UserLike> userLikes = user.getThisUserLiked();

                log.info("Total likes count: " + userLikes.size());
                for (UserLike userLike : userLikes) {
                    log.info("User '" + userLike.getAuthor().getName() + "' like it");
                }
            } else if (entity.equals("Photo")) {
                Photo photo = session.get(Photo.class, entityId);
                List<PhotoLike> photoLikes = photo.getLikes();

                log.info("Total likes count: " + photoLikes.size());
                for (PhotoLike photoLike : photoLikes) {
                    log.info("User '" + photoLike.getAuthor().getName() + "' like it");
                }
            } else if (entity.equals("Comment")) {
                Comment comment = session.get(Comment.class, entityId);
                List<CommentLike> commentLikes = comment.getLikes();

                log.info("Total likes count: " + commentLikes.size());
                for (CommentLike commentLike : commentLikes) {
                    log.info("User '" + commentLike.getAuthor().getName() + "' like it");
                }
            }

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while getting likes", e);
            session.getTransaction().rollback();
        }
    }
}
