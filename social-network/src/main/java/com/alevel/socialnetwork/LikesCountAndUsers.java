package com.alevel.socialnetwork;

import com.alevel.socialnetwork.entity.Photo;
import com.alevel.socialnetwork.entity.PhotoLike;
import com.alevel.socialnetwork.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class LikesCountAndUsers {
    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);

    public static void main(String[] args) {
        Class entity = Photo.class;
        long entityId = 2l;

        SessionFactory sessionFactory = HibernateSessionFactoryUtil.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            Transaction transaction = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PhotoLike> cr = cb.createQuery(PhotoLike.class);
            Root<PhotoLike> root = cr.from(PhotoLike.class);
            cr.select(root).where(cb.equal(root.get("targetPhoto"), entityId));

            Query<PhotoLike> query = session.createQuery(cr);
            List<PhotoLike> results = query.getResultList();

            log.info("Comments count: " + results.size());
            log.info("Users liked:");
            for (PhotoLike result : results) {
                log.info(result.getAuthor().getName());
            }

            transaction.commit();
        } catch (Exception e) {
            log.error("Error while populating db with example data", e);
            session.getTransaction().rollback();
        }
    }
}
