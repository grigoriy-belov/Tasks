package com.alevel.sales.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "departments")
public class DailyReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "profit")
    private BigDecimal profit;

    public DailyReport() {
    }

    public DailyReport(Date date, Department department, BigDecimal profit) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
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
                ", date=" + date +
                ", department=" + department +
                ", profit=" + profit +
                '}';
    }
}
