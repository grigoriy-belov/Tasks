package com.alevel.moboperator;

import com.alevel.moboperator.entity.*;
import com.alevel.moboperator.util.HibernateHelper;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PopulateWithCalls {
    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateHelper.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (sessionFactory; session) {
            session.beginTransaction();

            Tariff basic = session.load(Tariff.class, 1L);

            Customer customer2 = new Customer(
                    new Name("Mike", "Johnson"),
                    LocalDate.of(1990, 6, 25)
            );
            session.save(customer2);

            Account account1 = session.load(Account.class, 1L);
            Account account2 = new Account("+380501234567", customer2, basic);

            session.save(account2);

            LocalDateTime call1StartTime = LocalDateTime.of(2019, 12, 17, 10, 05, 00);
            LocalDateTime call1EndTime = LocalDateTime.of(2019, 12, 17, 10, 15, 30);
            Call call1 = new Call(account1, account2, call1StartTime, call1EndTime);

            LocalDateTime call2StartTime = LocalDateTime.of(2019, 12, 17, 11, 30, 00);
            LocalDateTime call2EndTime = LocalDateTime.of(2019, 12, 17, 12, 00, 00);
            Call call2 = new Call(account2, account1, call2StartTime, call2EndTime);

            session.save(call1);
            session.save(call2);

            session.getTransaction().commit();
        }
    }
}
