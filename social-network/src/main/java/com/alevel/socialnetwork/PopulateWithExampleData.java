package com.alevel.socialnetwork;

import com.alevel.socialnetwork.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alevel.socialnetwork.util.HibernateSessionFactoryUtil;

public class PopulateWithExampleData {

    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);
    
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();
        
        try (sessionFactory; session) {
            Transaction transaction = session.beginTransaction();

            User john = new User("John Smith");
            User samantha = new User("Samantha Collins");
            User robert = new User("Robert Brown");

            session.save(john);
            session.save(samantha);
            session.save(robert);

            Photo photo1 = new Photo("John's avatar", john);
            Photo photo2 = new Photo("Samantha's avatar", samantha);
            Photo photo3 = new Photo("Robert's avatar", robert);

            john.getPhotos().add(photo1);
            john.getPhotos().add(photo2);
            john.getPhotos().add(photo3);

            session.save(photo1);
            session.save(photo2);
            session.save(photo3);

            john.getPhotos().add(photo1);
            samantha.getPhotos().add(photo2);
            robert.getPhotos().add(photo3);

            Comment comment1 = new Comment("Very cute", john, photo2);
            Comment comment2 = new Comment("Nice photo", samantha, photo1);
            Comment comment3 = new Comment("Like it", robert, photo2);

            john.getComments().add(comment1);
            samantha.getComments().add(comment2);
            robert.getComments().add(comment3);

            session.save(comment1);
            session.save(comment2);
            session.save(comment3);

            Like like1 = new UserLike(john, samantha);
            Like like2 = new UserLike(samantha, john);
            Like like3 = new UserLike(robert, samantha);

            session.save(like1);
            session.save(like2);
            session.save(like3);

            Like photoLike1 = new PhotoLike(john, photo2);
            Like photoLike2 = new PhotoLike(samantha, photo1);
            Like photoLike3 = new PhotoLike(robert, photo2);

            session.save(photoLike1);
            session.save(photoLike2);
            session.save(photoLike3);

            Like commentLike1 = new CommentLike(john, samantha.getComments().get(0));
            Like commentLike2 = new CommentLike(samantha, john.getComments().get(0));
            Like commentLike3 = new CommentLike(robert, john.getComments().get(0));

            session.save(commentLike1);
            session.save(commentLike2);
            session.save(commentLike3);
//
//            john.getLikes().add(like1);
//            samantha.getLikes().add(like2);
//            robert.getLikes().add(like3);
//
//            john.getLikes().add(photoLike1);
//            samantha.getLikes().add(photoLike2);
//            robert.getLikes().add(photoLike3);
//
//            john.getLikes().add(commentLike1);
//            samantha.getLikes().add(commentLike2);
//            robert.getLikes().add(commentLike3);

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while populating db with example data", e);
            session.getTransaction().rollback();
        }
    }
}
