package com.alevel.moboperator;

import com.alevel.moboperator.entity.Account;
import com.alevel.moboperator.entity.Promotion;
import com.alevel.moboperator.entity.Tariff;
import com.alevel.moboperator.util.HibernateHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class PromotionsForAccount {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateHelper.createSessionFactory();
        Session session = sessionFactory.openSession();
        try (sessionFactory; session) {
            session.beginTransaction();
            String phoneNumber = args[0];
            Account account = session.bySimpleNaturalId(Account.class).load(phoneNumber);
            Tariff tariff = account.getTariff();

            for (Promotion promotion : tariff.getPromotions()) {
                System.out.println(promotion.getName() + ": " + promotion.getDescription());
            }

            session.getTransaction().commit();
        }
    }
}
