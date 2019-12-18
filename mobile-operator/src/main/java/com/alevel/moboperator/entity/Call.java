package com.alevel.moboperator.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "calls")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_account_id", nullable = false)
    private Account fromAcc;

    @ManyToMany (cascade = { CascadeType.ALL })
    @JoinTable(
            name = "calls_accounts",
            joinColumns = { @JoinColumn(name = "call_id")},
            inverseJoinColumns = { @JoinColumn(name = "to_account_id")}
    )
    private List<Account> toAccList = new ArrayList<>();

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    public Call() {
    }

    public Call(Account fromAcc, LocalDateTime startTime, LocalDateTime endTime) {
        this.fromAcc = fromAcc;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(Account fromAcc) {
        this.fromAcc = fromAcc;
    }

    public List<Account> getToAccList() {
        return toAccList;
    }

    public void setToAccList(List<Account> toAccList) {
        this.toAccList = toAccList;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void addToAccList(Account account) {
        toAccList.add(account);
    }

    public void removeFromAccList(Account account) {
        toAccList.remove(account);
    }
}

