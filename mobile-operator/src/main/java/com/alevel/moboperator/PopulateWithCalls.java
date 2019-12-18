package com.alevel.moboperator;

import com.alevel.moboperator.entity.Account;
import com.alevel.moboperator.entity.Call;
import com.alevel.moboperator.util.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class PopulateWithCalls {
    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateHelper.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            session.beginTransaction();

            Account account1 = session.load(Account.class, 1L);
            Account account2 = session.load(Account.class, 5L);
            Account account3 = session.load(Account.class, 6L);

            LocalDateTime startTime = LocalDateTime.now();
            LocalDateTime endTime = startTime.plusMinutes(15);

            Call call = new Call(account1, startTime, endTime);

            call.addToAccList(account2);
            call.addToAccList(account3);

            session.save(call);

            startTime = startTime.plusDays(1);
            endTime = startTime.plusMinutes(30);
            Call call2 = new Call(account2, startTime, endTime);
            call2.addToAccList(account1);
            call2.addToAccList(account3);

            session.save(call2);
            session.getTransaction().commit();
        }
    }
}
