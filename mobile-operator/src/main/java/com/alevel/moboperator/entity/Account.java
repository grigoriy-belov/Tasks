package com.alevel.moboperator.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private long balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tariff_id", nullable = false)
    private Tariff tariff;

    @OneToMany(mappedBy = "fromAcc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Call> outgoingCalls = new ArrayList<>();

    @OneToMany(mappedBy = "toAcc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Call> incomingCalls = new ArrayList<>();

    public Account() {
    }

    public Account(String phoneNumber, Customer customer, Tariff tariff) {
        this.phoneNumber = phoneNumber;
        this.customer = customer;
        this.customer.getAccounts().add(this);
        this.tariff = tariff;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public List<Call> getOutgoingCalls() {
        return outgoingCalls;
    }

    public void setOutgoingCalls(List<Call> outgoingCalls) {
        this.outgoingCalls = outgoingCalls;
    }
}
