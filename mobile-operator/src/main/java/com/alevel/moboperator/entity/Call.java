package com.alevel.moboperator.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "call_log")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_account_id", nullable = false)
    private Account fromAcc;

    @ManyToOne
    @JoinColumn(name = "to_acc_id", nullable = false)
    private Account toAcc;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    public Call() {
    }

    public Call(Account fromAcc, Account toAcc, LocalDateTime startTime, LocalDateTime endTime) {
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
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

    public Account getToAcc() {
        return toAcc;
    }

    public void setToAcc(Account toAcc) {
        this.toAcc = toAcc;
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
}
