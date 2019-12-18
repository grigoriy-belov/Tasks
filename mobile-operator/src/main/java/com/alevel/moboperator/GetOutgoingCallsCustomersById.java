package com.alevel.moboperator;

import com.alevel.moboperator.entity.Account;
import com.alevel.moboperator.entity.Call;
import com.alevel.moboperator.entity.Customer;
import com.alevel.moboperator.util.HibernateHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class GetOutgoingCallsCustomersById {
    private static final Logger log = LoggerFactory.getLogger(PopulateWithExampleData.class);

    public static void main(String[] args) {
        Long id = 1L;
        SessionFactory sessionFactory = HibernateHelper.createSessionFactory();
        Session session = sessionFactory.openSession();

        try (session; sessionFactory) {
            session.beginTransaction();

            Customer sourceCustomer = session.load(Customer.class, id);

            List<Account> customerAccounts = sourceCustomer.getAccounts();
            Map<Long, Customer> receivers = new HashMap<>();

            for (Account customerAccount : customerAccounts) {
                List<Call> outgoingCalls = customerAccount.getOutgoingCalls();

                for (Call outgoingCall : outgoingCalls) {
                    List<Account> accounts = outgoingCall.getToAccList();
                    for (Account account : accounts) {
                        Customer customer = account.getCustomer();
                        receivers.put(customer.getId(), customer);
                    }
                }
            }

            for (Customer customer : receivers.values()) {
                log.info("Customer: {} {}, birthday: {}", customer.getName().getFirstName(),
                        customer.getName().getLastName(), customer.getBirthday());
            }

            session.getTransaction().commit();
        }
    }
}
