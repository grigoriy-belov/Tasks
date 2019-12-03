package com.alevel.sales.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "daily_reports")
public class DailyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "profit")
    private Long profit;

    public DailyReport() {
    }

    public DailyReport(LocalDate date, Department department, Long profit) {
        this.date = date;
        this.department = department;
        this.profit = profit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyReport that = (DailyReport) o;
        return id == that.id &&
                Objects.equals(date, that.date) &&
                Objects.equals(department, that.department) &&
                Objects.equals(profit, that.profit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, department, profit);
    }

    @Override
    public String toString() {
        return "com.alevel.sales.entity.DailyReport{" +
                "id=" + id +
                ", date=" + date.toString() +
                ", department=" + department +
                ", profit=" + profit +
                '}';
    }
}
