package com.satge.satge.Repository;

import com.satge.satge.Entity.WorkDay;
import com.satge.satge.Entity.WorkDayId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDay, WorkDayId> {
    List<WorkDay> findByEmployeeIdAndDateBetween(int employeeId, Date startDate, Date endDate);
}
