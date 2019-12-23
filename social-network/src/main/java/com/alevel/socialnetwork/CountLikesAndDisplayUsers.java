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
//        long entityId = 2L;
//
//        Class entityClass = User.class;
//
//        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        try (session; sessionFactory) {
//            Transaction transaction = session.beginTransaction();
//            Object entity = session.get(entityClass, entityId);
//
//            List likes = null;
//
//            if (entity instanceof User) {
//                likes = ((User) entity).getUserLikes();
//            } else if (entity instanceof Photo) {
//                likes = ((Photo) entity).getLikes();
//            } else if (entity instanceof Comment) {
//                likes = ((Comment) entity).getLikes();
//            }
//
//            log.info("Total number of likes: " + likes.size());
//            for (Object like : likes) {
////                log.info("User '" + ((_Like) like).getAuthor().getName() + "' like it");
//            }
//
//            transaction.commit();
//        } catch (Exception e) {
//            log.error("Error while populating db with example data", e);
//            session.getTransaction().rollback();
//        }
    }
}
