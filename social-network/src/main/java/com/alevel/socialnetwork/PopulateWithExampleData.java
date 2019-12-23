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

            session.save(photo1);
            session.save(photo2);
            session.save(photo3);

            john.getPhotos().add(photo1);
            samantha.getPhotos().add(photo2);
            robert.getPhotos().add(photo3);

            Comment comment1 = new Comment("Very cute", john, photo2);
            Comment comment2 = new Comment("Nice photo", samantha, photo1);
            Comment comment3 = new Comment("Like it", robert, photo2);

            session.save(comment1);
            session.save(comment2);
            session.save(comment3);

            UserLike like1 = new UserLike(john, samantha);
            UserLike like2 = new UserLike(samantha, john);
            UserLike like3 = new UserLike(robert, samantha);

            session.save(like1);
            session.save(like2);
            session.save(like3);

            PhotoLike photoLike1 = new PhotoLike(john, photo2);
            PhotoLike photoLike2 = new PhotoLike(samantha, photo1);
            PhotoLike photoLike3 = new PhotoLike(robert, photo2);

            session.save(photoLike1);
            session.save(photoLike2);
            session.save(photoLike3);

            CommentLike commentLike1 = new CommentLike(john, comment2);
            CommentLike commentLike2 = new CommentLike(samantha, comment1);
            CommentLike commentLike3 = new CommentLike(robert, comment2);

            session.save(commentLike1);
            session.save(commentLike2);
            session.save(commentLike3);

            john.addUserLike(like1);
            samantha.addUserLike(like2);
            robert.addUserLike(like3);

            john.addPhotoLike(photoLike1);
            samantha.addPhotoLike(photoLike2);
            robert.addPhotoLike(photoLike3);

            john.addCommentLike(commentLike1);
            samantha.addCommentLike(commentLike2);
            robert.addCommentLike(commentLike3);

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while populating db with example data", e);
            session.getTransaction().rollback();
        }
    }
}
