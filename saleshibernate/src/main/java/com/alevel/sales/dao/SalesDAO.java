package com.alevel.sales.dao;

import com.alevel.sales.entity.DailyReport;
import com.alevel.sales.entity.Department;

import java.util.List;

public interface SalesDAO {
    List<DailyReport> getDailyReportsForYear(int year);
}
